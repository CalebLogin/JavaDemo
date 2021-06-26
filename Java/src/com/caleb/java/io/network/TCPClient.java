package com.caleb.java.io.network;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Date 2021/6/18 11:49
 * 基于TCP协议的客户端编程步骤
 * 1 创建客户端套接字，指定服务器的地址和端口号
 * 2 获取输入输出流
 * 3 处理数据
 * 4 关闭资源
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        //* 1 创建客户端套接字，指定服务器的地址和端口号
        Socket socket=new Socket("10.9.74.253", 9999);
        //* 2 获取输入输出流
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw=new OutputStreamWriter(os,"utf-8");
        BufferedWriter bw=new BufferedWriter(osw);
        //* 3 处理数据
        bw.write("好久不见");
        //* 4 关闭资源
        bw.close();
        socket.close();
        System.out.println("发送完毕");

    }
}
