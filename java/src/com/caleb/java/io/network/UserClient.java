package com.caleb.java.io.network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Date 2021/6/18 16:21
 * 用户客户端
 */
public class UserClient {
    public static void main(String[] args) {
        System.out.println("===========1.注册 2.登录===========");
        Scanner input=new Scanner(System.in);
        int choice=input.nextInt();
        switch (choice){
            case 1:
                Socket socket=null;
                try {
                    User user = getUserInfo();
                    //创建客户端套接字
                    socket=new Socket("10.9.74.253", 6666);
                    OutputStream os = socket.getOutputStream();
                    ObjectOutputStream oos=new ObjectOutputStream(os);
                    //把对象发给服务器
                    oos.writeObject(user);
                    InputStream is = socket.getInputStream();
                    BufferedReader br=new BufferedReader(new InputStreamReader(is,"utf-8"));
                    //读取服务器的回复
                    String s = br.readLine();
                    System.out.println("服务器回复:"+s);
                    oos.close();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }
    public static User getUserInfo(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入id");
        int id=input.nextInt();
        System.out.println("请输入姓名");
        String name=input.next();
        System.out.println("请输入密码");
        String pwd=input.next();
        System.out.println("请输入年龄");
        int age=input.nextInt();
        System.out.println("请输入成绩");
        double score=input.nextDouble();
        User user=new User(id, name, pwd, age,score );
        return user;
    }
}
