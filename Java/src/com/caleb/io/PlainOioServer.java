package com.caleb.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author：hanzhigang
 * @Date : 2021/4/13 4:33 PM
 */
public class PlainOioServer {

    /**
     * Blocking network without Netty
     *
     * @param port
     * @throws IOException
     */
    public void serverBio(int port) throws IOException {
        // 绑定服务器到指定的接口
        final ServerSocket socket = new ServerSocket(port);

        try {
            while (true) {

                // 接受一个连接
                final Socket clientSocket = socket.accept();
                System.out.println("Accepted connection from " + clientSocket);

                // 创建一个新的线程来处理连接
                new Thread(() -> {
                    OutputStream out;
                    try {

                        // 将消息发送到连接的客户端
                        out = clientSocket.getOutputStream();
                        out.write("Hi!\r\n".getBytes(StandardCharsets.UTF_8));
                        out.flush();
                        // 一旦消息被写入和刷新时就关闭连接
                        clientSocket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            clientSocket.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void serverAio(int port) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
        serverSocket.bind(address);

        final ByteBuffer buffer = ByteBuffer.wrap("Hi!\r\n".getBytes());
        while (true) {
            try {
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            Set<SelectionKey> readKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readKeys.iterator();

            while (iterator.hasNext()) {

                SelectionKey selectionKey = iterator.next();
                iterator.remove();

                try {
                    if (selectionKey.isAcceptable()) {

                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = server.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, buffer.duplicate());
                        System.out.println("Accepted connection from " + socketChannel);

                    } else if (selectionKey.isReadable()) {

                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                        while (byteBuffer.hasRemaining()) {
                            // 将数据写入到所连接的客户端。如果网络饱和，连接是可写的，那么这个循环将写入数据，直到该缓冲区是空的。
                            if (socketChannel.write(byteBuffer) == 0) {
                                break;
                            }
                        }
                        socketChannel.close();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
