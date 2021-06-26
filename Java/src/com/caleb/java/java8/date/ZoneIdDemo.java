package com.caleb.java.java8.date;

import java.time.ZoneId;
import java.util.Set;

/**
 * @Date 2021/6/21 17:15
 * ZoneID：时区类
 */
public class ZoneIdDemo {
    public static void main(String[] args) {
        //获取当前时区
        ZoneId now = ZoneId.systemDefault();
        System.out.println(now);
        //获取所有的时区
        System.out.println("---------------");
        Set<String> sets = ZoneId.getAvailableZoneIds();
        System.out.println(sets.size());
        for (String set : sets) {
            System.out.println(set);
        }
    }
}
