package com.caleb.java.io.file;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * 使用字节缓冲流写入文件
 */
public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws Exception{
        //1创建缓冲流
        FileOutputStream fos=new FileOutputStream("d:\\buffer.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);//缓冲区大小8KB
        //2写入文件
        String s="good good study,day day up\r\n";
        for(int i=0;i<10;i++){
            bos.write(s.getBytes());

        }
        //bos.flush();//刷新缓冲区
        //3关闭（只需要关闭缓冲流，就相当于关闭了的节点流），自动刷新缓冲区
        bos.close();
    }
}
