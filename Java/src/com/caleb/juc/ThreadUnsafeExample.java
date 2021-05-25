package com.caleb.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author：hanzhigang
 * @Date : 2021/3/1 2:49 PM
 */
public class ThreadUnsafeExample {
    public static void main(String[] args) throws InterruptedException {

        final int threadSize = 1000;
        ThreadErrorTest example = new ThreadErrorTest();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.getCnt());
    }

}

class ThreadErrorTest{
    private int cnt = 0;
    public void add(){
        cnt++;
    }

    public int getCnt() {
        return cnt;
    }
}
