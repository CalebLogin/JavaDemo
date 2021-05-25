package com.eric.juc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author：hanzhigang
 * @Date : 2021/3/10 9:17 AM
 */
public class ThreadPoolExecutorCallableExample {

    public static final int CORE_POOL_SIZE = 5;
    public static final int MAX_POOL_SIZE = 10;
    public static final int QUEUE_CAPACITY = 100;
    public static final long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
//      使用阿里巴巴推荐的线程池创建方法
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());


        List<Future<String>> list = new ArrayList<>();
        MyCallable myCallable = new MyCallable();
        for (int i = 0; i < 10; i++) {
//          提交任务到线程池
            Future<String> future = threadPoolExecutor.submit(myCallable);

            list.add(future);

        }
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(new Date() + " : " + list.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        threadPoolExecutor.shutdown();


    }

}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
//      休眠1s
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
