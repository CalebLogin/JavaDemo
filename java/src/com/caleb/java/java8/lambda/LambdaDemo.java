package com.caleb.java.java8.lambda;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Date 2021/6/21 11:21
 * 演示Lambda的使用
 */
public class LambdaDemo {
    public static void main(String[] args) {
        //示例1 Runnable接口
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程执行了1...");
            }
        };
        new Thread(runnable).start();
        //Lambda表达式
        Runnable runnable2= ()->System.out.println("子线程执行了2...");
        new Thread(runnable2).start();

        new Thread(()->System.out.println("子线程执行了3...")).start();

        //示例2 Comparator比较器接口
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        //lambda表达式
        Comparator<Integer> comparator2= (o1, o2)-> o1-o2;
        TreeSet<Integer> treeSet=new TreeSet<>(comparator2);

        TreeSet<Integer> treeSet2=new TreeSet<>((o1, o2)-> o1-o2);
    }
}
