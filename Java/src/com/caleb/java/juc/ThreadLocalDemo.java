package com.caleb.java.juc;

import java.lang.reflect.Field;

/**
 * ThreadLocal
 *
 * @author：hanzhigang
 * @Date : 2021/4/1 1:19 PM
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> test("abc", false));
        t1.start();
        t1.join();
        System.out.println("------GC------");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
    }

    public static void test(String s, boolean isGC) {

        try {
            new ThreadLocal<>().set(s);
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object ThreadLocalMap = field.get(t);
            Class<?> tlmClass = ThreadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(ThreadLocalMap);
            for (Object o : arr){
                if(o != null){
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referencedField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referencedField.setAccessible(true);
                    System.out.println(String.format("弱引用key：%s, 值：%s",referencedField.get(o),valueField.get(o)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
