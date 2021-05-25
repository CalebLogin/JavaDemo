package com.caleb.juc;

/**
 * @author：hanzhigang
 * @Date : 2021/3/4 3:12 PM
 */
public class WaitAndNotifyExample {

    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4();
        synchronized (myThread4){
            myThread4.start();
            try {
                Thread.sleep(3000);
                System.out.println("before wait");
                myThread4.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
class MyThread4 extends Thread{

    @Override
    public void run() {
        synchronized (this){
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }
}