package com.caleb.java.io.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Date 2021/6/18 14:51
 */
public class HandleClient implements Runnable {
    private Socket socket;
    public HandleClient(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        if(socket!=null){//代码健壮性
            //接收数据
            BufferedReader br=null;
            try {
                InputStream is = socket.getInputStream();
                br=new BufferedReader(new InputStreamReader(is,"utf-8"));
                String data;
                while((data=br.readLine())!=null){//如果null，表示客户端已退出... 如果有异常，说明客户端非正常退出
                    System.out.println(socket.getInetAddress().getHostAddress()+":"+data);
                    if(data.equals("byebye")||data.equals("886")){
                        break;
                    }
                }
                System.out.println(socket.getInetAddress().getHostAddress()+"退出了聊天...");
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println(socket.getInetAddress().getHostAddress()+"异常退出了");
            } finally {
                //释放资源
                try {
                    br.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
