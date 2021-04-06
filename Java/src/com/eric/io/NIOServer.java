package com.eric.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO实例服务器端
 *
 * @author：hanzhigang
 * @Date : 2021/4/5 2:35 PM
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {

        // 创建selector选择器
        Selector selector = Selector.open();

        // 注册ServerSocket通道，并将通道注册到选择器上
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 创建网络套接字并绑定地址和端口
        ServerSocket serverSocket = ssChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
        serverSocket.bind(address);

        while (true) {

            selector.select();
            // 获得选择器的监听事件
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();

                    // 服务器为每一个新链接创建一个SocketChannel
                    SocketChannel sChannel = ssChannel1.accept();
                    sChannel.configureBlocking(false);
                    // 这个新链接主要用于从客户端读取数据
                    sChannel.register(selector, SelectionKey.OP_READ);

                } else if (key.isReadable()) {
                    SocketChannel sChannel = (SocketChannel) key.channel();
                    // 读取通道中的数据
                    System.out.println(sChannel.socket().toString()+readDataFromSocketChannel(sChannel));
                    sChannel.close();

                }
                iterator.remove();
            }
        }

    }

    /**
     * 在套接字通道中读取数据
     * @param socketChannel
     * @return
     * @throws IOException
     */
    public static String readDataFromSocketChannel(SocketChannel socketChannel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        StringBuffer data = new StringBuffer();

        while (true) {

            buffer.clear();
            int n = socketChannel.read(buffer);
            if (n == -1) {
                break;
            }

            buffer.flip();
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) buffer.get(i);
            }

            data.append(dst);
            buffer.clear();
        }

        return data.toString();

    }
}
