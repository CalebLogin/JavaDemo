package com.caleb.java.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author：hanzhigang
 * @Date : 2021/3/4 7:07 PM
 */
class Depot {
    //  记录当前生产的数量
    private int size;
    //  最大允许的容量
    private int capacity;
    private Lock lock;
    //  容量达到最大的条件队列
    private Condition fullCondition;
    //  容量为空的条件队列
    private Condition emptyCondition;

    public Depot(int capacity) {
        this.capacity = capacity;
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    //  生产者
    public void producer(int no) {
//      上锁，该线程不能被其他线程打断
        lock.lock();
//      记录向队列中加入多少数量产品
        int left = no;
        try {
            while (left > 0) {
//              如果当前产品数量达到最大容量，将当前线程加入等待队列
                while (size >= capacity) {
                    System.out.println(Thread.currentThread() + " : before await");
//                  挂起线程，释放锁权限
                    fullCondition.await();
                    System.out.println(Thread.currentThread() + " : after await");
                }
//              增量等于正常加入的大小或者剩余容量的大小
                int inc = (capacity - size) > left ? left : (capacity - size);
//              用来判断当前是否已经完成生产，若left大于inc，则说明还有部分产品没有生产，等待当前队列唤醒后，继续生产。
//              否则不再生产，退出while循环。
                left -= inc;
                size += inc;
                System.out.println("producer : " + inc + ", size= " + size);
//              唤醒消耗产品队列
                emptyCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      生产完成，解锁
        lock.unlock();
    }

    //  消费者
    public void consumer(int no) {
//      上锁，该线程不能被其他线程打断
        lock.lock();
        int left = no;
        try {
//          要消耗的数量大于0时，继续消耗产品
            while (left > 0) {
//              当现有产品清零时，将消费线程阻塞，emptyCondition进入等待队列
                while (size <= 0) {
                    System.out.println(Thread.currentThread() + " : before await");
//                  挂起线程，释放锁权限
                    emptyCondition.await();
                    System.out.println(Thread.currentThread() + " : after await");
                }
//              消耗产品数量
                int dec = (size - left) > 0 ? left : size;
                left -= dec;
                size -= dec;
                System.out.println("consumer : " + dec + ", size= " + size);
                fullCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      消费完成，解锁
        lock.unlock();
    }

}

class ProducerCondition {
    private Depot depot;

    public ProducerCondition(Depot depot) {
        this.depot = depot;
    }

    public void produce(int no) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                depot.producer(no);
            }
        }, no + " producer thread").start();
    }
}

class ConsumerCondition {
    private Depot depot;

    public ConsumerCondition(Depot depot) {
        this.depot = depot;
    }

    public void consume(int no) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                depot.consumer(no);
            }
        }, no + " consumer thread").start();
    }
}

public class ProducerAndConsumerReentrantLockExample {
    public static void main(String[] args) {
//      初始化为500的容量
        Depot depot = new Depot(500);
        new ProducerCondition(depot).produce(500);
        new ProducerCondition(depot).produce(200);
        new ConsumerCondition(depot).consume(200);
        new ConsumerCondition(depot).consume(500);
    }
}


