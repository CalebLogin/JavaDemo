package com.caleb.java.java8.lambda;

import java.util.function.Consumer;

/**
 * @Date 2021/6/21 14:57
 * 演示方法引用的使用:
 * 方法引用是Lambda表达式的一种简写形式。
 */
public class TestMethodRef {
    public static void main(String[] args) {
        //对象::实例方法
        //(1)Lambda表达式中只调用一个方法。(2) 调用这个方法的参数和返回值和接口中方法一致。
        Consumer<String> consumer=s-> System.out.println(s);
        Consumer<String> consumer2=System.out::println;
        consumer2.accept("hello");

//        PrintStream ps=new PrintStream("d:\\aaa.txt");
//        ps.println();

    }
}
