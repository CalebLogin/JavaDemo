package com.caleb.java.io.network;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Date 2021/6/18 14:25
 * 文件客户端：发送文件给服务器...
 */
public class FileClient {
    public static void main(String[] args) throws Exception{
        //1创建Socket，并指定服务器的地址和端口号
        Socket socket=new Socket("10.9.74.253", 8888);
        //2获取输入输出流
        OutputStream os = socket.getOutputStream();
        //3处理数据
        FileInputStream fis=new FileInputStream("d:\\图片\\copy.jpg");
        byte[] buf=new byte[1024];
        int len;
        while((len=fis.read(buf))!=-1){
            os.write(buf,0 ,len );
        }
        //4关闭
        fis.close();
        os.close();
        socket.close();
        System.out.println("发送完毕...");
    }
}
