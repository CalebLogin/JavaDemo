package com.eric.juc;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 没有采取同步操作的话，会抛出异常
 * 相对线程安全
 * @author：hanzhigang
 * @Date : 2021/3/1 3:20 PM
 */
public class VectorUnsafeExample {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while(true){
            for(int i=0;i<100;i++){
                vector.add(i);
            }

            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(()->{
                synchronized (vector){
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }

            });
            executorService.execute(()->{
                synchronized (vector){
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }

            });

            executorService.shutdown();

        }
    }

}
