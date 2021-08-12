package com.caleb.demo1;

import java.util.Date;

/**
 * @author：hanzhigang
 * @Date : 2021/2/26 2:06 PM
 */
public class DateTimeTest {

    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());

        Date date1 = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date1.toString());

    }
}
