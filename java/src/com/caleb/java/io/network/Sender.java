package com.caleb.java.io.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Date 2021/6/19 9:28
 * 发送方：使用UDP协议发送数据
 */
public class Sender {
    public static void main(String[] args) throws Exception{
        //1创建DatagramSocket对象,系统随机分配端口号(类似快递点)
        DatagramSocket ds=new DatagramSocket();
        //2创建DatagramPacket数据报包对象（类似于快递）
        String s="好久不见";
        DatagramPacket dp=new DatagramPacket(s.getBytes(), s.getBytes().length,
                InetAddress.getByName("10.9.74.253"), 9999);
        //3发送
        ds.send(dp);
        //4关闭
        ds.close();

    }
}
