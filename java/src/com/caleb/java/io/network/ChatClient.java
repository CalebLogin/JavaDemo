package com.caleb.java.io.network;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Date 2021/6/18 15:06
 * 聊天室客户端
 */
public class ChatClient {
    public static void main(String[] args) throws Exception{
        //1创建客户端套接字,并指定服务器的地址和端口号
        Socket socket=new Socket("10.9.74.253", 8800);
        //2获取输出流
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"utf-8"));
        //3处理
        Scanner input=new Scanner(System.in);
        while(true){
            String data=input.next();
            bw.write(data);
            bw.newLine();//一定要发换行符
            bw.flush();
            if(data.equals("byebye")||data.equals("886")){
                break;
            }
        }
        //4关闭资源
        bw.close();
        socket.close();
        System.out.println("客户端已退出了...");

    }
}
