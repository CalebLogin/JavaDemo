package com.caleb.java.io.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Date 2021/6/18 11:39
 * 基于TCP协议的服务器编程步骤:
 * 1 创建服务器套接字，并指定端口号
 * 2 侦听客户端的连接，并返回客户端套接字
 * 3 获取输入输出流
 * 4 处理数据
 * 5 关闭资源
 */
public class TCPServer {
    public static void main(String[] args) throws Exception{
        //1 创建服务器套接字，并指定端口号
        ServerSocket listener=new ServerSocket(9999);
        //2 侦听客户端的连接，并返回客户端套接字，阻塞方法
        System.out.println("服务器已启动...");
        Socket socket = listener.accept();
        //3 获取输入/输出流
        InputStream is = socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(is,"utf-8");
        BufferedReader br=new BufferedReader(isr);
        //4 处理数据
        String data = br.readLine();
        System.out.println("客户端说:"+data);
        //5 关闭资源
        br.close();
        socket.close();
        listener.close();
        System.out.println("服务器结束了...");
    }
}
