package com.caleb.java.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * 先调用unpark，再调用park，判断是否同步
 * @author：hanzhigang
 * @Date : 2021/3/4 3:41 PM
 */

class MyThread6 extends Thread{

    private Object object;

    public MyThread6(Object o) {
        this.object = o;
    }

    @Override
    public void run() {
        System.out.println("before unpark");
//      释放许可
        LockSupport.unpark((Thread) object);
        System.out.println("after unpark");
    }
}



public class ParkAndUnparkExample1 {
    public static void main(String[] args) {
        MyThread6 myThread6 = new MyThread6(Thread.currentThread());
        myThread6.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before park");
//      获取许可
        LockSupport.park("ParkAndUnparkExample");
        System.out.println("after park");
    }

}
