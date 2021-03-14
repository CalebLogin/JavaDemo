package com.eric.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author：hanzhigang
 * @date : 2021/1/23 8:49 PM
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        /**
         * 获取TargetObject类的class对象并创建TargetObject类实例
         */
        Class<?> targetClass = Class.forName("com.eric.demo.TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.newInstance();
        /**
         * 获取所有类中所有定义的方法
         */
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method: methods){
            System.out.println(method.getName());
        }

        /**
         * 获得指定方法并调用
         */
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject,"JavaGuide");

        /**
         * 获取指定参数并对参数进行修改
         */
        Field field = targetClass.getDeclaredField("value");
        /**
         * 为了对类中的参数进行修改我们取消安全检查
         */
        field.setAccessible(true);
        field.set(targetObject,"JavaGuide");

        /**
         * 调用private环境
         */
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }

}
