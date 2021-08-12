package com.caleb.java.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author：hanzhigang
 * @Date : 2021/3/1 9:26 AM
 */
public class H2OTest {
}

/**
 * 为什么不能用一个flag？？？？
 *
 * 屏障法
 */
class H2O1{

//  输出H的锁
    private boolean hflag = true;
//  输出O的锁
    private boolean oflag = true;
//  统计输出H的次数
    private int hCount = 0;
//  监控器
    private byte[] lock = new byte[0];

    public H2O1() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        synchronized (lock){
            while(!hflag){//当hflag为false时,wait()
                lock.wait();
            }
            releaseHydrogen.run();
            hCount++;
            if(hCount==2){
                hCount = 0;
                hflag = false;//关闭H
                oflag = false;//激活O
                lock.notifyAll();
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        synchronized (lock){
            while(oflag){
                lock.wait();
            }
            releaseOxygen.run();
            oflag = true;//关闭O
            hflag = true;//激活H
            lock.notifyAll();
        }
    }
}

/**
 * 使用信号量和栏栅来实现
 */
class H2O2{
//  输出H函数的信号量
    private Semaphore hSemaphore = new Semaphore(2);
//  输出O函数的信号量
    private Semaphore oSemaphore = new Semaphore(1);

    private CyclicBarrier barrier = new CyclicBarrier(3,()->{
        hSemaphore.release(2);
        oSemaphore.release(1);
    });

    public H2O2() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        hSemaphore.acquire();
        releaseHydrogen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oSemaphore.acquire();
        releaseOxygen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 使用ReentLock和Condition来实现
 */
class H2O3{

    private Lock lock = new ReentrantLock();
//  H元素，满足条件的队列
    private Condition hCondition = lock.newCondition();
//  O元素，满足条件的队列
    private Condition oCondition = lock.newCondition();
//  原子整数，保证线程安全
    private AtomicInteger hInteger  = new AtomicInteger(2);
    private AtomicInteger oInteger  = new AtomicInteger(0);

    public H2O3() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        lock.lock();

//      ???
        while(hInteger.get() == 0){
            hCondition.await();
        }
//      hInteger减一
        hInteger.decrementAndGet();
//      执行操作
        releaseHydrogen.run();
//      oInteger加一
        oInteger.incrementAndGet();
        if(oInteger.get()==2){
//          唤醒所有sCondition的线程
            oCondition.signalAll();
        }

        lock.unlock();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        lock.lock();
//      hCondition队列等待的线程不足2个，继续等待
        while (oInteger.get()!=2){
            oCondition.await();
        }
//      执行操作
        releaseOxygen.run();
//      等待序列线程达到三个，恢复至初始状态
        oInteger.getAndSet(0);
        hInteger.getAndSet(2);

//      重新唤醒hCondition上的所有线程
        hCondition.signalAll();

        lock.unlock();
    }
}
