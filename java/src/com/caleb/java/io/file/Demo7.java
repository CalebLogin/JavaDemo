package com.caleb.java.io.file;

import java.io.PrintStream;

/**
 * @Date 2021/6/17 14:22
 * System.out属性
 *  默认打印到控制台。
 *  重定向标准输出流(System.out重新初始化)
 *
 */
public class Demo7 {
    public static void main(String[] args) throws Exception{
        System.out.println("hello");
        PrintStream ps=new PrintStream("d:\\out.txt");
//        重定向标准输出流
        System.setOut(ps);
        System.out.println("世界你好");

    }
}
