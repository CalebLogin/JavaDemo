package com.caleb.java.juc;

import java.util.function.IntConsumer;

/**
 * @author：hanzhigang
 * @Date : 2021/3/20 8:08 PM
 */
public class FizzBuzzExample {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread thread1 = new Thread(()->{
            try {
                fizzBuzz.fizz(()->{
                    System.out.println("fizz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(()->{
            try {
                fizzBuzz.buzz(()->{
                    System.out.println("buzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(()->{
            try {
                fizzBuzz.fizzbuzz(()->{
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread4 = new Thread(()->{
            try {
                fizzBuzz.number((int value)->{
                    System.out.println(value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class FizzBuzz{
    private int n;
    private volatile int count = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(true){
            while((count % 3 != 0 || count % 15 == 0) && count <= n){
                wait();
            }
            if(count > n){
                notifyAll();
                break;
            }
            printFizz.run();
            count++;
            notifyAll();
        }

    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(true){
            while((count % 5 != 0 || count % 15 == 0) && count<=n){
                wait();
            }
            if(count > n){
                notifyAll();
                break;
            }
            printBuzz.run();
            count++;
            notifyAll();
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true){
            while((count % 15 != 0) && count <= n){
                wait();
            }
            if(count > n){
                notifyAll();
                break;
            }
            printFizzBuzz.run();
            count++;
            notifyAll();
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(true){
            while((count % 3 == 0 || count % 5 == 0) && count <= n){
                wait();
            }
            if(count > n){
                notifyAll();
                break;
            }
            printNumber.accept(count);
            count++;
            notifyAll();
        }

    }
}