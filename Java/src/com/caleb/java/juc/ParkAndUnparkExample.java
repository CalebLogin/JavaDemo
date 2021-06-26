package com.caleb.java.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author：hanzhigang
 * @Date : 2021/3/4 3:27 PM
 */

class MyThread5 extends Thread{

    private Object object;
    public MyThread5(Object o){
        object = o;
    }
    @Override
    public void run() {
        System.out.println("before unpark");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      获取blocker
        System.out.println("Blocker info "+LockSupport.getBlocker((Thread) object));
//      释放许可
        LockSupport.unpark((Thread) object);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      获取blocker
        System.out.println("Blocker info "+LockSupport.getBlocker((Thread) object));
        System.out.println("after unpack");

    }
}

public class ParkAndUnparkExample {
    public static void main(String[] args) {

        MyThread5 myThread5 = new MyThread5(Thread.currentThread());
        myThread5.start();

        System.out.println("before park");
//      获取许可
        LockSupport.park("ParkAndUnparkExample");
        System.out.println("after park");

    }
}
