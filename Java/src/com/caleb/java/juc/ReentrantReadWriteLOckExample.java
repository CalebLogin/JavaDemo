package com.caleb.java.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: hanzhigang
 * @Date : 2021/4/26 13:33
 */
public class ReentrantReadWriteLockExample {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReadThread rt1 = new ReadThread("rt1", reentrantReadWriteLock);
        ReadThread rt2 = new ReadThread("rt2", reentrantReadWriteLock);
        WriteThread wt1 = new WriteThread("wt1", reentrantReadWriteLock);
        rt1.start();
        rt2.start();
        wt1.start();
    }

}


class ReadThread extends Thread {
    private ReentrantReadWriteLock rrwLock;

    public ReadThread(String name, ReentrantReadWriteLock rrwLock) {
        super(name);
        this.rrwLock = rrwLock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " trying to lock");

        try {
            Thread.sleep(5000);
            rrwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " lock successfully");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rrwLock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }

    }
}

class WriteThread extends Thread {

    private ReentrantReadWriteLock rrwLock;

    public WriteThread(String name, ReentrantReadWriteLock rrwLock) {
        super(name);
        this.rrwLock = rrwLock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " trying lock");
        try {
            rrwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " lock successfully");
        } finally {
            rrwLock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }
    }
}
