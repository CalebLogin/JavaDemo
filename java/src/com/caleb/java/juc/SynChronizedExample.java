package com.caleb.java.juc;

/**
 * @author：hanzhigang
 * @Date : 2021/3/1 5:04 PM
 */
public class SynChronizedExample {
    byte[] object = new byte[0];

    public void method1() {
        synchronized (object) {

        }
    }
}
