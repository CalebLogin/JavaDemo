package com.caleb.java.io.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Date 2021/6/17 11:43
 * InputStreamReader：字节流通向字符流的桥梁,指定编码读取文件
 * OutputStreamWriter：字符流流通向字节流的桥梁,指定编码写入文件
 */
public class Demo5 {
    public static void main(String[] args)throws Exception {
        //read();
        write();
    }
    public static void read()throws Exception{
        //1创建转换流
        FileInputStream fis=new FileInputStream("d:\\reader.txt");
        InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
        //2读取
        char[] buf=new char[1024];
        int len;
        while((len=isr.read(buf))!=-1){
            String s=new String(buf,0,len);
            System.out.print(s);
        }
        //3关闭
        isr.close();
    }
    public static void write()throws Exception{
        //1创建流
        FileOutputStream fos=new FileOutputStream("d:\\haha.txt");
        OutputStreamWriter osw=new OutputStreamWriter(fos,"GBK");
        //2写入f
        for(int i=0;i<10;i++) {
            osw.write("欢迎使用Java语言\r\n");
            osw.flush();
        }
        //3关闭
        osw.close();

    }
}
