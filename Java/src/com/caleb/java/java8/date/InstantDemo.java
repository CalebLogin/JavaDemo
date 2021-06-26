package com.caleb.java.java8.date;

import java.time.Duration;
import java.time.Instant;

/**
 * @Date 2021/6/21 17:05
 * Instant类的使用: 从1970开始计算时间。类似Date
 */
public class InstantDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建今天
        Instant now=Instant.now();
        System.out.println(now);
        System.out.println(now.toEpochMilli());
        //创建昨天
        Instant yesterday = now.minusMillis(60 * 60 * 24 * 1000);
        System.out.println(yesterday);
        //创建明天
        Instant tomorrow = now.plusMillis(60 * 60 * 24 * 1000);
        System.out.println(tomorrow);
        //计时
        Instant start=Instant.now();
        Thread.sleep(5000);
        Instant end=Instant.now();
        long t = Duration.between(start, end).toMillis();
        System.out.println(t);

    }
}
