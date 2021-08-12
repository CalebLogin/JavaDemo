package com.caleb.java.io.file;

import java.io.PrintWriter;

/**
 * @Date 2021/6/17 14:15
 * 使用打印流打印数据
 * PrintStream:字节打印流
 * PrintStream:字符打印流
 */
public class Demo6 {
    public static void main(String[] args) throws Exception{
        //1创建打印流
       // PrintStream ps=new PrintStream("d:\\print.txt");
        PrintWriter ps=new PrintWriter("d:\\print.txt");
        //2打印数据(数据原样打印)
        ps.println(97);
        ps.println('a');
        ps.println("helloworld");
        ps.println(3.1415926);
        ps.println(true);
        //3关闭
        ps.close();
        System.out.println("执行完毕...");
    }
}
