package com.caleb.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 快速错误机制
 *
 * @author：hanzhigang
 * @Date : 2021/4/10 12:01 PM
 */
public class FailFast {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        ThreadOne threadTwo = new ThreadOne();
        new Thread(threadOne).start();
        new Thread(threadTwo).start();
    }

    private static void printAll() {
        String value = null;
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            value = (String) iterator.next();
            System.out.println(value);
        }
    }

    private static class ThreadOne implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                list.add(String.valueOf(i));
                printAll();
            }
        }
    }

}
