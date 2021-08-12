package com.caleb.java.java8.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Date 2021/6/21 17:19
 * 时间转换
 *  1 Date--->Instant--->LocalDateTime
 */
public class Demo {
    public static void main(String[] args) {
        //1 Date--->Instant--->LocalDateTime
        Date date=new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime);
        //2 LocalDateTime--->Instant--->Date
        Instant instant2 = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant2);
        Date date2 = Date.from(instant2);
        System.out.println(date2);
    }
}
