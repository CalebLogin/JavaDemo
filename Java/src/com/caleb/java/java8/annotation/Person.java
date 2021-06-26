package com.caleb.java.java8.annotation;


import java.lang.reflect.Method;

/**
 * @Date 2021/6/21 10:13
 */

public class Person {

    @MyAnnotation(name="树桐",age=20)
    public void show(){
        System.out.println("show方法");
        //通过反射获取注解信息
        //1获取类对象
        Class<Person> class1 = Person.class;
        try {
            //2获取方法
             Method method=class1.getMethod("show");
            //3获取注解
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            //4获取注解属性
            System.out.println(annotation.name());
            System.out.println(annotation.age());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
