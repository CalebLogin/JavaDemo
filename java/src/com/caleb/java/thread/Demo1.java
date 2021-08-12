package com.caleb.java.thread;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示ConcurrentLinkedQueue的使用,线程安全的队列
 */
public class Demo1 {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<>();
        ExecutorService es = Executors.newFixedThreadPool(3);
        //入队
        for(int i=0;i<3;i++) {
           es.submit(new Runnable() {
               @Override
               public void run() {
                   queue.offer(Thread.currentThread().getName()+"..."+new Random().nextInt(100));
               }
           });
        }
        es.shutdown();
        while(!es.isTerminated()){}
        //出队
        int size=queue.size();
        for(int i=0;i<size;i++){
            System.out.println(queue.poll());
        }
    }
}
