package com.caleb.java.io.network;
import java.net.InetAddress;

/**
 * @Date 2021/6/18 11:17
 * InetAddress类的使用:表示IP地址对象
 */
public class Demo1 {
    public static void main(String[] args)throws Exception {
        //1 本地IP地址
        InetAddress ia1 = InetAddress.getLocalHost();
        System.out.println("IP地址:"+ia1.getHostAddress()+"主机名："+ia1.getHostName());
        InetAddress ia2 = InetAddress.getByName("10.9.74.253");
        System.out.println("IP地址:"+ia2.getHostAddress()+"主机名："+ia2.getHostName());
        InetAddress ia3 = InetAddress.getByName("127.0.0.1");
        System.out.println("IP地址:"+ia3.getHostAddress()+"主机名："+ia3.getHostName());
        InetAddress ia4 = InetAddress.getByName("localhost");
        System.out.println("IP地址:"+ia4.getHostAddress()+"主机名："+ia4.getHostName());
        //2 局域网ip地址
//        InetAddress ia5=InetAddress.getByName("10.9.74.241");
//        System.out.println("IP地址:"+ia5.getHostAddress()+"主机名："+ia5.getHostName());
//        System.out.println(ia5.isReachable(3000));
        //3 外网ip地址
        InetAddress ia6=InetAddress.getByName("www.baidu.com");
        System.out.println("IP地址:"+ia6.getHostAddress()+"主机名："+ia6.getHostName());
        System.out.println("----------------");
        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress.getHostAddress());
        }
    }
}
