package com.eric.juc;

/**
 * @author：hanzhigang
 * @Date : 2021/4/1 4:29 PM
 */
public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        threadLocal.set("父类数据：threadLocal");
        inheritableThreadLocal.set("父类数据：inheritableThreadLocal数据");

        new Thread(() -> {
            System.out.println("子线程获取父类ThreadLocal数据：" + threadLocal.get());
            System.out.println("子线程获取父类inheritableThreadLocal数据：" + inheritableThreadLocal.get());
        }).start();
    }
}
