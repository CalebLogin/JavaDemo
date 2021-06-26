package com.caleb.java.io.file;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @Date 2021/6/17 11:01
 * FileReader的使用
 * 使用默认的字符编码和缓冲区大小读取文本文件。
 * FileWriter的使用
 * 使用默认的字符编码和缓冲区大小写入文件。
 */
public class Demo3 {
    public static void main(String[] args) throws Exception{
        write();
    }
    public static void read() throws Exception{
        //1创建文件字符输入流
        FileReader fr=new FileReader("d:\\reader.txt");
        //2读取
        //2.1单个字符读取
//        int d;
//        while((d=fr.read())!=-1){
//            System.out.print((char)d);
//        }
        //2.2多个字符读取
        char[] buf=new char[1024];
        int len;
        while((len=fr.read(buf))!=-1){
            String s=new String(buf,0,len);
            System.out.print(s);
        }
        //3关闭
        fr.close();
    }
    public static void write() throws Exception{
        //1创建字符文件输出流
        FileWriter fw=new FileWriter("d:\\write.txt");
        //2写入
        for(int i=0;i<10;i++){
            fw.write("好好学习，天天向上\r\n");//Windows换行\r\n （新版本\r、\n） Linux \n  Mac \r
            fw.flush();//刷新缓冲
        }
        //3关闭
        fw.close();
        System.out.println("写入完毕");
    }
}
