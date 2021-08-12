package com.caleb.java.io.reflect;

import java.io.Serializable;

/**
 * @Date 2021/6/19 10:25
 * 学生类
 */
public class Student implements Serializable,Comparable<Student> {
    //属性
    private String name;
    private int age;
    //构造方法
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student() {
    }
    //无参无返回值方法
    public void show(){
        System.out.println("学生姓名:"+this.name+"，年龄"+this.age);
    }
    //带参方法
    public void show(String address){
        System.out.println("学生地址:"+address);
    }
    //带返回值方法
    public String getAddress(){
        return "北京";
    }
    //私有方法
    private void study(){
        System.out.println("好好学习，天天向上");
    }
    //静态方法
    public static void exam(){
        System.out.println("学生开始考试");
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
