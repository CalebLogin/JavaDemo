package com.caleb.java.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Date 2021/6/21 16:20
 * (3)终止操作
 * 3.1 forEach、min、max、count
 * 3.2 reduce、collect
 */
public class StreamDemo3 {
    public static void main(String[] args) {
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
        //3.1 forEach、min、max、count
        //forEach 遍历
       // list.forEach(System.out::println);
        list.stream().forEach(System.out::println);
        //min 最小值
        System.out.println("-------min 最小值---------");
        //Optional对象：用来封装数据，防止空指针异常。
//        Optional<Employee> min = list.stream()
//                .min((o1, o2) -> Double.compare(o1.getSalary() ,o2.getSalary()));
//        Employee e = min.get();
//        System.out.println(e.toString());
        //max最小值
        Optional<Employee> max = list.stream()
                .max((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()));
        Employee e = max.get();
        System.out.println(e.toString());
        //count 统计个数
        long count = list.stream().count();
        System.out.println(count);

        //reduce(归约，统计)、collect(收集)
        //统计所有人的工资和
        Optional<Double> sum = list.stream()
                .map(x -> x.getSalary())
                .reduce((x1, x2) -> x1 + x2);
        System.out.println(sum.get());
        //collect （收集）
        //收集所有人的姓名
        //Collectors工具类
        List<String> names = list.stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());
        System.out.println(names);
    }
}
