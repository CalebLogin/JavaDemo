package com.caleb.java.io.file;

import java.io.FileInputStream;

/**
 * @Date 2021/6/16 15:26
 * 使用FileInputStream(文件字节输入流)读取文件
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception{
        //1创建FileInputStream对象
        FileInputStream fis=new FileInputStream("d:\\aaa.txt");
        //2读取
        //2.1 单个字节读取
//        int data;
//        while((data=fis.read())!=-1){
//            System.out.print((char)data);
//        }
        //2.2一次读取多个字节
        byte[] buf=new byte[1024];
        int len;//实际读取的长度
        while((len=fis.read(buf))!=-1){
            String s=new String(buf, 0, len);
            System.out.print(s);
        }
        //3关闭
        fis.close();
    }
}
