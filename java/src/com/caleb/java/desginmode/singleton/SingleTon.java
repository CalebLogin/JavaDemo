package com.caleb.java.desginmode.singleton;

/**
 * @Date 2021/6/19 16:29
 * 单例的三个步骤
 * (1)私有化构造方法
 * (2)在类中创建一个对象
 * (3)添加公开的方法，返回这个对象
 *
 * 饿汉式: 类加载时初始化单例对象。优点：没有线程安全问题，缺点: 声明周期长，浪费空间。
 */
public class SingleTon {
    //私有化构造方法
    private SingleTon(){ }
    //在类中创建一个对象
    private static final SingleTon INSTANCE=new SingleTon();
    //添加公开的方法，返回这个对象
    public static  SingleTon getInstance(){
        return INSTANCE;
    }

}
