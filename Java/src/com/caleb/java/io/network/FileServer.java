package com.caleb.java.io.network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Date 2021/6/18 14:18
 * 文件服务器:
 */
public class FileServer {
    public static void main(String[] args) throws Exception{
        //1创建服务器套接字，并指定端口号
        ServerSocket listener=new ServerSocket(8888);
        //2侦听，并返回客户端套接字
        System.out.println("服务器已启动...");
        Socket socket = listener.accept();
        //3获取输入输出流
        InputStream is = socket.getInputStream();
        //4处理数据
        byte[] buf=new byte[1024];
        int len;
        FileOutputStream fos=new FileOutputStream("d:\\aaa.jpg");
        while((len=is.read(buf))!=-1){
            fos.write(buf,0, len );
        }
        //5关闭
        fos.close();
        is.close();
        socket.close();
        listener.close();
        System.out.println("服务器接收完毕...");
    }
}
