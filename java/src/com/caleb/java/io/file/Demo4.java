package com.caleb.java.io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @Date 2021/6/17 11:28
 * 字符缓冲流的使用
 */
public class Demo4 {
    public static void main(String[] args) throws Exception{
       // read();
        write();
    }
    public static void read() throws Exception{
        //1创建字符缓冲输入流
        FileReader fr=new FileReader("d:\\reader.txt");
        BufferedReader br=new BufferedReader(fr);
        //2读取
//        String line = br.readLine();
//        System.out.println(line);
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        //3关闭
        br.close();
    }

    public static void write() throws Exception{
        //1创建字符缓冲输出流
        FileWriter fw=new FileWriter("d:\\write2.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        //2写入
        for(int i=0;i<10;i++){
            bw.write("java是世界最好的编程语言");
            bw.newLine();//写入换行符
            bw.flush();//刷新缓冲
        }
        //3关闭
        bw.close();
        System.out.println("执行完毕");

    }
}
