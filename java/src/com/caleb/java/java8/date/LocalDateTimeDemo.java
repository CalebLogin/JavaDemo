package com.caleb.java.java8.date;

import java.time.LocalDateTime;

/**
 * @Date 2021/6/21 16:52
 * 演示:LocalDateTime 本地日期时间类的使用
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        //1创建当前日期时间: 类似Calendar
        LocalDateTime now=LocalDateTime.now();
        System.out.println(now);
        //2昨天
        LocalDateTime yesterday = now.minusDays(1);
        System.out.println(yesterday.toString());
        //3明天
        LocalDateTime tomorrow = now.plusDays(1);
        System.out.println(tomorrow);
        //4创建指定日期时间的对象
        LocalDateTime localDateTime=LocalDateTime.of(1921, 7, 1, 10, 10, 20);
        System.out.println(localDateTime);
        //5获取日期和时间部分
        System.out.println("年:"+now.getYear());
        System.out.println("月:"+now.getMonthValue());
        System.out.println("日:"+now.getDayOfMonth());
        System.out.println("小时:"+now.getHour());
        System.out.println("分钟:"+now.getMinute());
        System.out.println("秒:"+now.getSecond());


    }
}
