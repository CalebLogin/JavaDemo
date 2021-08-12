package com.caleb.java.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Date 2021/6/21 15:34
 * Stream的使用步骤
 * (1) 新建流
 *    四种方式
 *    1.1 通过Collection集合的stream()或parallelStream()方法。
 *    1.2 通过Arrays类的stream()方法。
 *    1.3 通过Stream接口的of()、iterate()、generate()方法。
 *    1.4 通过IntStream、LongStream、DoubleStream接口中的of、range、rangeClosed方法。
 *
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        //1.1 通过Collection集合的stream()或prallelStream()方法
        ArrayList<String> list=new ArrayList<>();
        list.add("张三");
        list.add("王五");
        list.add("赵六");
        list.add("张树桐");
        list.add("李富康");
        Stream<String> stream = list.stream();//串行流（单线程）
        Stream<String> stream2 = list.parallelStream();//并行流（多线程）
        //链式编程
        stream.filter(s->s.startsWith("张"))
              .forEach( System.out::println);
        //1.2 通过Arrays.stream();
        int[] nums={20,50,30,100,200,150};
        IntStream stream3 = Arrays.stream(nums);
        stream3.forEach(System.out::println);
        //1.3 通过Stream接口的of()、iterate()、generate()方法。
        Stream<String> stream4 = Stream.of("北京", "上海", "广州", "杭州", "深圳");
        stream4.forEach(System.out::println);
        //1.4 通过IntStream、LongStream、DoubleStream接口中的of、range、rangeClosed方法。
        IntStream range = IntStream.rangeClosed(0, 100);
        range.forEach(System.out::println);


    }
}
