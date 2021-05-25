package com.caleb.juc;

/**
 * 创建多线程的方法，通过实现Runnable的接口，来实现run的方法
 *
 * 方法1：同步代码块
 * synchronized(){
 *
 * }
 * 方法2：同步方法
 *
 *
 *
 * @author：hanzhigang
 * @Date : 2021/2/24 5:55 PM
 */
public class ThreadRunnableExample{
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread thread1 = new Thread(mThread);
        Thread thread2 = new Thread(mThread);
        Thread thread3 = new Thread(mThread);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class MThread implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while(true){
            synchronized (this){
                notify();
                if(ticket > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":"+ticket);
                    ticket--;
                }else{
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
