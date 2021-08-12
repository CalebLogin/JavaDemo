package com.caleb.java.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * @Date 2021/6/16 9:48
 * 使用阻塞队列实现生产者和消费者
 * BlockingQueue:
 *   ArrayBlockingQueue:数组实现的阻塞队列
 *   LinkedBlockingQueue: 链表实现的阻塞队列
 */
public class Demo2 {
    public static void main(String[] args) {
        //创建阻塞队列，容量设置为6
        BlockingQueue<String> blockingQueue=new LinkedBlockingQueue<>(6);
        //生产功能
        Runnable produce=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<30;i++){
                    try {
                        blockingQueue.put("面包:"+i);
                        System.out.println(Thread.currentThread().getName()+"生产了"+i+"号面包");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //消费功能
        Runnable consume=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<30;i++){
                    try {
                        String b=blockingQueue.take();
                        System.out.println(Thread.currentThread().getName()+"消费了"+b);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(produce);
        es.submit(consume);
        es.shutdown();

    }
}
