package com.caleb.java.thread;

/**
 * @Date 2021/6/16 11:12
 */
public class Demo3 {
    public static void main(String[] args) {
        AtomicDemo atomicDemo=new AtomicDemo();
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(atomicDemo.getValue());
                }
            }).start();
        }
    }
}
