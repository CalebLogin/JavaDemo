import com.alibaba.otter.canal.common.utils.AddressUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;

/**
 * @author：hanzhigang
 * @Date : 2021/4/6 6:57 PM
 */
public class NettyClient {

    private final ByteBuffer readBuffer = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
    private final ByteBuffer writeBuffer = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
    private SocketChannel socketChannel;

    public void sendMessage(byte[] body) throws IOException {
        // 创建客户端通道
        socketChannel = SocketChannel.open();
        socketChannel.socket().setSoTimeout(60000);
        socketChannel.connect(new InetSocketAddress(AddressUtils.getHostIp(), 1088));

        // 客户端发请求
        writeWithHeader(socketChannel, body);

        // 接收服务端响应的信息
        readBuffer.clear();
        read(socketChannel, readBuffer);
        int bodyLen = readBuffer.getInt(0);
        ByteBuffer bodyBuffer = ByteBuffer.allocate(bodyLen).order(ByteOrder.BIG_ENDIAN);
        read(socketChannel, bodyBuffer);
        System.out.println("<客户端>收到的响应内容: " + new String(bodyBuffer.array(), "UTF-8") + ",长度: " + bodyLen);

    }

    private void writeWithHeader(SocketChannel channel, byte[] body) throws IOException {
        writeBuffer.clear();
        writeBuffer.putInt(body.length);
        writeBuffer.flip();
        channel.write(ByteBuffer.wrap(body));
    }

    private void read(SocketChannel channel, ByteBuffer byteBuffer) throws IOException {
        while (byteBuffer.hasRemaining()) {
            int r = channel.read(byteBuffer);
            if (r == -1) {
                throw new IOException("end of stream when reading header");
            }
        }
    }

    public static void main(String[] args) {
        String body = "客户端发来的测试请求";
        try {
            new NettyClient().sendMessage(body.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
