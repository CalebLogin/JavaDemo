package com.caleb.java.io.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author wgy
 * @version V1.0
 * @Project day24
 * @Package com.qf.day24
 * @Description: ${TODO}
 * @Date 2021/6/19 9:28
 * 接收方:使用UDP协议接收数据
 */
public class Receiver {
    public static void main(String[] args) throws Exception{
        //1 创建DatagramSocket对象，并指定端口号
        DatagramSocket ds=new DatagramSocket(9999);
        //2 创建DatagramPacket数据报包对象
        byte[] data=new byte[1024*64];
        DatagramPacket dp=new DatagramPacket(data, data.length);
        //3 接收(阻塞方法),没有数据报包停止执行。
        System.out.println("准备接收...");
        ds.receive(dp);
        //4 处理
        // getData();获取数据
        // getLength();返回实际数据的长度
        String s=new String(dp.getData(),0,dp.getLength());
        System.out.println("发送方说:"+s);
        //5关闭
        ds.close();
    }
}
