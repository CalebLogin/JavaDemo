package com.caleb.java.io.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 案例：使用FileInputStream和FileOutputStream实现图片的复制
 */
public class CopyFile {
    public static void main(String[] args) throws Exception{
        //1创建流
        //1.1创建FileInputStream
        FileInputStream fis=new FileInputStream("d:\\copy.jpg");
        //1.2创建FileOutpuStream
        FileOutputStream fos=new FileOutputStream("d:\\copy2.jpg");
        //2 读取和写入
        byte[] buf=new byte[1024];
        int len;
        while((len=fis.read(buf))!=-1){
            fos.write(buf, 0, len);
        }
        //3关闭
        fis.close();
        fos.close();
        System.out.println("复制完毕...");
    }
}
