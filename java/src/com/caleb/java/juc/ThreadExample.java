package com.caleb.java.juc;

/**
 * 继承Thread实现使用线程
 * @author：hanzhigang
 * @Date : 2021/2/24 5:27 PM
 */
public class ThreadExample{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for(int i=0;i<100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+"******main*******");
            }
            if(i == 20){
                try {
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
