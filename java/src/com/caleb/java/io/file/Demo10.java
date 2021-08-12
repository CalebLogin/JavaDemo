package com.caleb.java.io.file;

import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date 2021/6/17 15:17
 * 模拟使用四个线程下载一个4M的文件
 */
public class Demo10 {
    public static void main(String[] args) {
        //文件
        byte[] data=new byte[1024*1024];
        //创建线程池
        ExecutorService es = Executors.newFixedThreadPool(4);
        //提交任务
        for(int i=0;i<4;i++){
            int n=i;
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //创建RandomAccessFile对象
                        System.out.println(Thread.currentThread().getName()+"开始下载");
                        RandomAccessFile raf=new RandomAccessFile("d:\\电影.mp4", "rw");
                        //设置文件指针的偏移
                        raf.seek(1024*1024*n);
                        //写入
                        raf.write(data);
                        //关闭
                        raf.close();
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName()+"下载完毕...");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        es.shutdown();
        while(!es.isTerminated()){}
        System.out.println("文件下载完毕...");
    }
}
