package com.caleb.juc;

/**
 * 测试Thread中的join方法，在线程A调用线程B的join()方法后，会先执行完线程B中的资源，接着执行线程A中的资源
 * @author：hanzhigang
 * @Date : 2021/3/1 4:33 PM
 */
public class ThreadjoinExample {

    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        myThread3.setName("Thread-1");
        myThread3.start();
        for(int i=0;i<100;i++){
            if(i == 20){
                try {
                    myThread3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }

    }

}


class MyThread3 extends Thread{

    @Override
    public void run() {

//      每隔0.1秒打印一次i
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }
}
