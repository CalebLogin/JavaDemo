package com.eric.juc;

/**
 * @author：hanzhigang
 * @Date : 2021/2/28 5:57 PM
 */
class Foo {

    private byte[] lock = new byte[0];
    private volatile int flag = 1;


    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while(flag != 1){
            synchronized (lock){
                lock.wait();
            }
        }
        printFirst.run();
        flag = 2;
        lock.notifyAll();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(flag != 2){
            synchronized (lock){
                lock.wait();
            }
        }
        printSecond.run();
        lock.notifyAll();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(flag != 3){
            synchronized (lock){
                lock.wait();
            }
        }
        printThird.run();
    }

    public static void main(String[] args) {

    }


}
