package com.caleb.java.io.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @Date 2021/6/18 15:56
 * 服务器注册功能
 */
public class RegistThread extends Thread {
    @Override
    public void run() {
        //实现注册功能
        ServerSocket listener=null;
        Socket socket=null;
        try {
            listener=new ServerSocket(6666);
            System.out.println("服务器注册已启动...");
            socket = listener.accept();
            //获取输入输出流
            InputStream is = socket.getInputStream();
            ObjectInputStream ois=new ObjectInputStream(is);
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"utf-8"));
            //处理数据
            User user=(User) ois.readObject();
            //读取硬盘中的文件
            File file=new File("d:\\users.bin");
            ArrayList<User> list=null;
            if(file.exists()){//存在
                //读取文件
                ObjectInputStream ois2=new ObjectInputStream(new FileInputStream(file));
                list=(ArrayList<User>) ois2.readObject();
                ois2.close();
            }else{//不存在
                list=new ArrayList<>();
            }
            //判断id是否已经存在
            boolean flag=false;//假如不存在
            for (User u : list) {
                if(u.getId()==user.getId()){
                    flag=true;
                }
            }
            if(flag){//id已存在
                bw.write("用户id已存在");
            }else{
                 //写入硬盘
                list.add(user);
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(list);
                oos.close();
                bw.write("注册成功");
            }
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                listener.close();
                System.out.println("服务器注册已结束...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
