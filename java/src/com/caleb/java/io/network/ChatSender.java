package com.caleb.java.io.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @Date 2021/6/19 9:50
 * 聊天室发送方
 */
public class ChatSender {
    public static void main(String[] args) throws Exception{
        //1创建DatagramSocket,随机分配端口号
        DatagramSocket ds=new DatagramSocket();
        //2创建DatagramPacket
        Scanner input=new Scanner(System.in);
        while(true) {
            String data=input.next();
            DatagramPacket dp = new DatagramPacket(data.getBytes(), data.getBytes().length,
                    InetAddress.getByName("10.9.74.255"), 8888);
            //3发送
            ds.send(dp);
            if(data.equals("byebye")||data.equals("886")){
                break;
            }
        }
        //4关闭
        ds.close();

    }
}
