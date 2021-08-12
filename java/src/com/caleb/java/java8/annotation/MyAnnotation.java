package com.caleb.java.java8.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Date 2021/6/21 10:10
 * 使用@interface定义一个注解
 * 注意事项:
 * 注解中只能包含属性,属性后面需要写小括号。
 */
@Retention(RetentionPolicy.RUNTIME)
//@Target(value = {ElementType.TYPE})
public @interface MyAnnotation {
    //属性
    String name();
    int age();
//    String[] cities();
//    Class class1();
//    Gender sex();
//    Override o();
//    String name();
}
