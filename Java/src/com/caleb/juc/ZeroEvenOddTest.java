package com.caleb.juc;

import java.util.function.IntConsumer;

/**
 * @author：hanzhigang
 * @Date : 2021/2/28 8:26 PM
 */
class ZeroEvenOdd {
    private int n;
    private volatile boolean flag = true;
    private volatile int count = 1;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while (count <= n) {
            while (!flag) {
                wait();
                if(count>n){
                    return;
                }
            }
            printNumber.accept(0);
            flag = false;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (count<=n) {
            while (flag) {
                wait();
                if(count>n){
                    return;
                }
            }
            if(count % 2 == 0) {
                printNumber.accept(count);
                count++;
                flag = true;
                notifyAll();
            }else{
                wait();
            }
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (count<=n) {
            while (flag) {
                wait();
                if(count>n){
                    return;
                }
            }
            if(count % 2 != 0) {
                printNumber.accept(count);
                count++;
                flag = true;
                notifyAll();
            }else{
                wait();
            }
        }
    }
}

class ZeroEvenOddTest1 extends Thread{
    ZeroEvenOdd zeroEvenOdd = null;
    IntConsumer intConsumer = null;

    ZeroEvenOddTest1(ZeroEvenOdd zeroEvenOdd,IntConsumer intConsumer){
        this.zeroEvenOdd = zeroEvenOdd;
        this.intConsumer = intConsumer;
    }

    @Override
    public void run() {
        while (true){
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ZeroEvenOddTest2 extends Thread{

    ZeroEvenOdd zeroEvenOdd = null;
    IntConsumer intConsumer = null;

    ZeroEvenOddTest2(ZeroEvenOdd zeroEvenOdd,IntConsumer intConsumer){
        this.zeroEvenOdd = zeroEvenOdd;
        this.intConsumer = intConsumer;
    }
    @Override
    public void run() {
        while (true){
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class ZeroEvenOddTest3 extends Thread{

    ZeroEvenOdd zeroEvenOdd = null;
    IntConsumer intConsumer = null;

    ZeroEvenOddTest3(ZeroEvenOdd zeroEvenOdd,IntConsumer intConsumer){
        this.zeroEvenOdd = zeroEvenOdd;
        this.intConsumer = intConsumer;
    }

    @Override
    public void run() {
        while (true){
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ZeroEvenOddTest{


    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);
        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };
        ZeroEvenOddTest1 zeroEvenOddTest1 = new ZeroEvenOddTest1(zeroEvenOdd,intConsumer);
        ZeroEvenOddTest2 zeroEvenOddTest2 = new ZeroEvenOddTest2(zeroEvenOdd,intConsumer);
        ZeroEvenOddTest3 zeroEvenOddTest3 = new ZeroEvenOddTest3(zeroEvenOdd,intConsumer);
        zeroEvenOddTest1.start();
        zeroEvenOddTest2.start();
        zeroEvenOddTest3.start();
    }
}