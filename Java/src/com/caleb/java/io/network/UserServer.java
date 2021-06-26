package com.caleb.java.io.network;

/**
 * @Date 2021/6/18 15:55
 * 用户服务器：注册，登录
 */
public class UserServer {
    public static void main(String[] args) {
        RegistThread registThread=new RegistThread();
        LoginThread loginThread=new LoginThread();
        registThread.start();
        loginThread.start();
    }
}
