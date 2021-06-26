package com.caleb.java.java8.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @Date 2021/6/21 15:55
 * (2)中间操作
 *   2.1 filter(过滤)、limit(限制)、skip(跳过)、distinct(去重)、sorted(排序)
 *   2.2 map()
 *   2.3 parallel();
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        //2.1 filter(过滤)、limit(限制)、skip(跳过)、distinct(去重)、sorted(排序)
        Employee e1=new Employee("张三", 20, 12000);
        Employee e2=new Employee("李四", 18, 10000);
        Employee e3=new Employee("王五", 25, 18000);
        Employee e4=new Employee("树桐", 22, 22000);
        Employee e5=new Employee("富康", 23, 25000);
        ArrayList<Employee> list=new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e5);
        System.out.println("-------------filter过滤--------------");
        //filter过滤
        //创建流
        Stream<Employee> stream = list.stream();
        //中间操作
        //过滤年龄大于等于20
        stream.filter(e->e.getAge()>=20)
                .forEach(System.out::println);
        System.out.println("----------");
        //过滤工资大于等于20000
        list.stream()
                .filter(e->e.getSalary()>=20000)
                .forEach(System.out::println);
        //limit 限制
        System.out.println("-------------limit 限制-------------");
        list.stream()
                .limit(2)
                .forEach(System.out::println);
        //skip 跳过
        System.out.println("-------------skip 跳过------------");
        list.stream()
                .skip(2)
                .limit(2)
                .forEach(System.out::println);
        //distinct:去重， 重复元素依据 hashCode和equals
        System.out.println("-------------distinct:去重------------");
        list.stream()
                .distinct()
                .forEach(System.out::println);
        //sorted 排序
        System.out.println("-------------sorted 排序------------");
        list.stream()
                .sorted((o1,o2)->o1.getAge()-o2.getAge())
                .forEach(System.out::println);
        //2.2 map映射
        //打印所有员工姓名
        System.out.println("-------- map 映射-------");
        list.stream()
                .map(e->e.getName())
                .forEach(System.out::println);

        //2.3 parallel 并行流
        list.stream()
                .parallel();

    }
}
