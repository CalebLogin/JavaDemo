package com.eric.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * 查看中断与unpark中间的作用是否相同
 *
 * @author：hanzhigang
 * @Date : 2021/3/4 3:51 PM
 */

class MyThread7 extends Thread {

    private Object object;

    public MyThread7(Object o) {
        this.object = o;
    }

    @Override
    public void run() {
        System.out.println("before interrupt");
        try {
            //      休眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = (Thread) object;
        thread.interrupt();
        System.out.println("after interrupt");

    }
}

public class ParkAndInterruptExample {
    public static void main(String[] args) {
        MyThread7 myThread7 = new MyThread7(Thread.currentThread());
        myThread7.start();
        System.out.println("before park");
//      获取许可
        LockSupport.park("ParkAndInterruptExample");
        System.out.println("after park");
    }
}
