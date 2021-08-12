package com.caleb.java.io.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * 使用字节缓冲流读取文件
 */
public class BufferedInputStreamDemo {
    public static void main(String[] args) throws Exception{
        //1创建字节缓冲流
        FileInputStream fis=new FileInputStream("d:\\aaa.txt");
        BufferedInputStream bis=new BufferedInputStream(fis);//默认缓冲区 8K
        //2读取
        int data;
        while((data=bis.read())!=-1){//先把数据读取到缓冲区，然后从缓冲区中取。
            System.out.print((char)data);
        }
        //3关闭(关闭缓冲流，相当于关闭了节点流)
        bis.close();
    }
}
