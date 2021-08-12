package com.caleb.java.io.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 内存流的使用
 * ByteArrayInputStream:内存输入流
 * ByteArrayOutputStream:内存输出流
 */
public class Demo2 {
    public static void main(String[] args) throws Exception{
        input();
    }
    public static void output() throws Exception{
        //1创建内存输出流
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        //2输出(写入)
        String s="helloworld";
        baos.write(s.getBytes());
        //3关闭(可选)
        baos.close();
        byte[] data = baos.toByteArray();
        String s2=new String(data);
        System.out.println(s2);
    }

    public static void input() throws Exception{
        byte[] data="helloworld".getBytes();
        //1创建内存输入流
        ByteArrayInputStream bais=new ByteArrayInputStream(data);
        //2读取数据
        int d;
        while((d=bais.read())!=-1){
            System.out.print((char)d);
        }
        //3关闭
        bais.close();
    }
}
