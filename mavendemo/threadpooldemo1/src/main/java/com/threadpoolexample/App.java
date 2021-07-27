package com.threadpoolexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("stats-pool-%d").build();
        ExecutorService statThreadPool = new ThreadPoolExecutor(5,
                10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(100), threadFactory);
        for(int i = 0;i<100;i++){
            jobs j = new jobs();
            j.setName(i + " ");
            statThreadPool.submit(j);
        }
    }

}

class jobs extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("正在执行" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
