package com.caleb.java.io.file;

import java.io.FileOutputStream;

/**
 * @Date 2021/6/16 16:04
 * 使用FileOutputStream(文件字节输出流)写入文件
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws Exception{
        //1创建FileOutpuStream
        FileOutputStream fos=new FileOutputStream("d:\\out.txt",true);
        //2写入
       // fos.write(97);
        String s="helloworld";
        fos.write(s.getBytes());
        //3关闭
        fos.close();
        System.out.println("程序执行完毕...");
    }
}
