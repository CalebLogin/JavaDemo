package com.eric.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author：hanzhigang
 * @Date : 2021/2/25 1:52 PM
 */

class NumberThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadCallableExample {
    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();

        FutureTask futureTask = new FutureTask(numberThread);

        new Thread(futureTask).start();
        try {
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
