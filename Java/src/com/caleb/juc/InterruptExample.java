package com.caleb.juc;

/**
 * 线程中中断例子
 * @author：hanzhigang
 * @Date : 2021/3/1 3:56 PM
 */
public class InterruptExample {

    public static void main(String[] args) {
        /*MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        myThread1.interrupt();
        System.out.println("Main run");*/
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        myThread2.interrupt();
        System.out.println("Main run");
    }

}

class MyThread1 extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {

    @Override
    public void run() {
        while (!interrupted()){

        }
        System.out.println("Thread run");
    }
}
