package com.caleb.java.java8.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Date 2021/6/21 17:27
 * SimpleDateFormat ：格式化日期, 线程安全问题。
 * DateTimeFormatter: JDK1.8中添加的新的格式化时间类
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        //1 日期格式化为字符串
        LocalDateTime now=LocalDateTime.now();
        System.out.println(now);
        //创建格式化类
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/M/d HH:mm:ss");
        String format = dtf.format(now);
        System.out.println(format);

        //2 字符串解析为日期
        String s="1997/10/15 10:20:30";
        LocalDateTime parse = LocalDateTime.parse(s, dtf);
        System.out.println(parse);

    }
}
