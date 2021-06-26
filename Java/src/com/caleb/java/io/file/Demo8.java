package com.caleb.java.io.file;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Date 2021/6/17 14:29
 *  System.in属性
 *  类型 InputStream
 *  默认从控制台读取数据
 */
public class Demo8 {
    public static void main(String[] args) throws Exception{
//        Scanner input=new Scanner(System.in);
//        InputStream is=new FileInputStream("d:\\aaa.txt");
//        is.read();//读取一个字节
        //1 使用Sytsem.in读取一个字节
//        int d=System.in.read();//读取一个字节(从控制台)
//        System.out.println((char)d);
        //2 使用System.in读取一个字符
//        InputStreamReader isr=new InputStreamReader(System.in);
//        int d=isr.read();
//        System.out.println((char)d);
        //3 使用System.in读取多个字符
//        InputStreamReader isr=new InputStreamReader(System.in);
//        BufferedReader br=new BufferedReader(isr);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        System.out.println(line);

        Scanner input=new Scanner(System.in);

    }
}
