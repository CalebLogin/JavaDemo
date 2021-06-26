package com.caleb.java.thread;

/**
 * @Date 2021/6/16 10:06
 */
public class TestMyThread {
    public static void main(String[] args)throws Exception {
        MyThread thread=new MyThread();
        thread.start();
        System.out.println("输入任意字符结束子线程");
        System.in.read();
        thread.flag=false;
        System.out.println("主线程结束了..."+thread.flag);
    }
}
