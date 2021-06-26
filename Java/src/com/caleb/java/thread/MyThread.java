package com.caleb.java.thread;

/**
 * @Date 2021/6/16 10:05
 */
public class MyThread extends Thread {
    volatile boolean flag=true;//volatile ：保证内存可见性
    @Override
    public void run() {
        System.out.println("子线程开始执行......");
        while(true){
            if (!flag) {
                break;
            }
        }
        System.out.println("子线程结束了......");
    }
}
