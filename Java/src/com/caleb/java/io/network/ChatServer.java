package com.caleb.java.io.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date 2021/6/18 14:46
 * 聊天服务器：
 * 使用多线程技术，接收多个客户端请求。
 */
public class ChatServer {
    public static void main(String[] args) {
        //1创建服务器套接字，并指定端口
        ServerSocket listener=null;
        ExecutorService es = Executors.newCachedThreadPool();
        //2侦听
        try {
            listener=new ServerSocket(8800);
            System.out.println("聊天室已启动...");
            while(true) {
                Socket socket = listener.accept();
                //创建线程
                es.submit(new HandleClient(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                listener.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            es.shutdown();
            System.out.println("服务器已关闭...");
        }

    }
}
