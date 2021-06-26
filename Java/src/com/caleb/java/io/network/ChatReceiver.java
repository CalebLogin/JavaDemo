package com.caleb.java.io.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Date 2021/6/19 9:45
 * 聊天室接收方
 */
public class ChatReceiver {
    public static void main(String[] args) {
        DatagramSocket ds=null;
        try {
            //1创建DatagramSocket，并指定端口号
            ds=new DatagramSocket(8888);
            //2创建DatagramPacket
            byte[] data=new byte[1024*64];
            DatagramPacket dp=new DatagramPacket(data, data.length);
            System.out.println("聊天室已启动...");
            //3接收
            while(true){
                ds.receive(dp);
                //4处理数据
                String s=new String(dp.getData(),0,dp.getLength());
                System.out.println(dp.getAddress().getHostAddress()+"说:"+s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5关闭
            ds.close();
        }
    }
}
