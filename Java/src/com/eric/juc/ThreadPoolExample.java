package com.eric.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author：hanzhigang
 * @Date : 2021/2/25 2:04 PM
 *
 * 创建线程的方式4：线程池
 */

class NumThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPoolExample{

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        NumThread numThread = new NumThread();
        NumberThread numberThread = new NumberThread();
        FutureTask futureTask = new FutureTask(numberThread);

        executorService.execute(numThread);//适用于Runnable
        executorService.submit(futureTask);//适用于Callable

        executorService.shutdown();


    }
}
