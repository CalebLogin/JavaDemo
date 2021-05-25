import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author：hanzhigang
 * @Date : 2021/4/6 3:24 PM
 */
public class SocketServer2 {
    static {
        BasicConfigurator.configure();
    }

    /**
     * 日志
     */
    private static final Log LOGGER = LogFactory.getLog(SocketServer2.class);

    /**
     * 将socketChannel的hashcode作为key，将客户端传过来的信息放入到服务端的一个内存区域MESSAGEHASHCONTEXT中
     */
    private static final ConcurrentHashMap<Integer, StringBuffer> MESSAGEHASHCONTEXT = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // 设置为非阻塞模式
        serverChannel.configureBlocking(false);
        ServerSocket serverSocket = serverChannel.socket();
        serverSocket.setReuseAddress(true); // 这里也可以丢弃，使用InetSocketAddress("URL",PORT)
        serverSocket.bind(new InetSocketAddress(83));

        Selector selector = Selector.open();
        // 服务器通道只能注册OP_ACCEPT事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        try {
            while (true) {
                Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                while (selectionKeys.hasNext()) {

                    SelectionKey selectionKey = selectionKeys.next();
                    selectionKeys.remove();
                    SelectableChannel selectableChannel = selectionKey.channel();

                    if (selectionKey.isValid() && selectionKey.isAcceptable()) {
                        SocketServer2.LOGGER.info("---------channel通道已经准备好-------------");

                        /**
                         * 当serverSocketChannel通道准备好，就可以拿到socketChannel。
                         * 之后将socketChannel感兴趣的事件注册到selector中，这样就使selector监听这个socketChannel的数据了
                         */
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectableChannel;
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        // 注册socketChannel
                        registerSocketChannel(socketChannel, selector);
                    } else if (selectionKey.isValid() && selectionKey.isConnectable()) {
                        SocketServer2.LOGGER.info("---------socket channel通道建立连接-------------");
                    } else if (selectionKey.isValid() && selectionKey.isReadable()) {
                        SocketServer2.LOGGER.info("---------socket channel通道数据准备完成，可以读取数据-------------");
                        readSocketChannel(selectionKey);
                    }
                }
            }
        } catch (IOException e) {
            SocketServer2.LOGGER.error(e.getMessage(), e);
        } finally {
            serverSocket.close();
        }


    }

    /**
     * 在ServerSocketChannel接收到/准备好一个新的TCP连接后
     * 就会向程序返回一个新的socketChannel
     * 拿到新的socketChannel后，向selector注册socketChannel感兴趣的事件
     *
     * @param socketChannel
     * @param selector
     * @throws IOException
     */
    private static void registerSocketChannel(SocketChannel socketChannel, Selector selector) throws IOException {
        /**
         * socketChannel通道也只能注册SelectionKey.OP_CONNECT,SelectionKey.OP_WRITE,SelectionKey.OP_READ这三种事件
         */
        socketChannel.configureBlocking(false); // 设置非阻塞模式
        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocateDirect(50));

    }

    /**
     * 该方法用于从客户端接受信息
     * 并且观察从客户端传输过来的socketChannel在经过多次传输后，是否完成传输
     *
     * @param selectionKey
     * @throws IOException
     */
    private static void readSocketChannel(SelectionKey selectionKey) throws IOException {

        SocketChannel clientSocketChannel = (SocketChannel) selectionKey.channel();

        // 获取客户端的端口
        InetSocketAddress sourceSocketAddress = (InetSocketAddress) clientSocketChannel.getRemoteAddress();
        Integer clientPort = sourceSocketAddress.getPort();

        // 拿到socketChannel使用的缓冲区，然后读取数据
        // 将通道的数据写入到缓冲区中
        ByteBuffer contextBytes = (ByteBuffer) selectionKey.attachment();

        int readLen = 0;
        StringBuffer message = new StringBuffer();

        try {
            readLen = clientSocketChannel.read(contextBytes);
        } catch (IOException e) {   // 客户端因为某些原因终止了，关闭channel
            SocketServer2.LOGGER.error(e.getMessage());
            clientSocketChannel.close();
            return;
        }

        while ((readLen = clientSocketChannel.read(contextBytes)) != 0) {
            contextBytes.flip();    // 改为读状态

            int position = contextBytes.position();
            int capacity = contextBytes.capacity();
            byte[] messageBytes = new byte[capacity];
            contextBytes.get(messageBytes, position, readLen);

            String messageEncode = new String(messageBytes, 0, readLen, "UTF-8");
            message.append(messageEncode);

            // 清空缓存，改为写状态
            contextBytes.clear();

        }

        // 收到over后表示接收完毕
        if (URLDecoder.decode(message.toString(), "UTF-8").indexOf("over") != -1) {

            Integer channelUUID = clientSocketChannel.hashCode();
            SocketServer2.LOGGER.info("端口" + clientPort + "客户端发来的信息是====message：" + URLDecoder.decode(message.toString(),"UTF-8"));

            StringBuffer completeMessage;
            // 清空MESSAGEHASHCONTEXT的历史记录
            StringBuffer historyMessage = MESSAGEHASHCONTEXT.remove(channelUUID);
            if(historyMessage == null){
                completeMessage = message;
            }else{
                completeMessage = historyMessage.append(message);
            }

            SocketServer2.LOGGER.info("端口" + clientPort + "客户端发来的完整信息是===completemessage：" + URLDecoder.decode(completeMessage.toString(),"UTF-8"));

            // 回发数据
            ByteBuffer sendBuffer = ByteBuffer.wrap(URLEncoder.encode("回发处理结果", "UTF-8").getBytes());
            clientSocketChannel.write(sendBuffer);
            clientSocketChannel.close();
        } else {
            SocketServer2.LOGGER.info("端口" + clientPort + "客户端发来的信息还未接受完，继续接受====message：" + URLDecoder.decode(message.toString(),"UTF-8"));
            Integer channelUUID = clientSocketChannel.hashCode();

            StringBuffer historyMessage = MESSAGEHASHCONTEXT.get(channelUUID);
            if(historyMessage == null){
                historyMessage = new StringBuffer(message);
                MESSAGEHASHCONTEXT.put(channelUUID,historyMessage);
            }else{
                MESSAGEHASHCONTEXT.get(channelUUID).append(message);
            }
        }


    }

}
