package com.caleb.java.desginmode.singleton;

/**
 * @Date 2021/6/19 16:40
 * 单例三个步骤
 * (1)私有化构造方法
 * (2)在类中创建一个对象
 * (3)添加公开的方法，返回这个对象
 * 懒汉式单例: 使用时才初始化对象，优点：节省空间  缺点：线程不安全，需要同步
 */
public class Boss {
    //私有化构造方法
    private Boss() {
    }

    //在类中创建一个对象
    public volatile static Boss instance;

    //添加公开的方法，返回这个对象
    public static Boss getInstance() {
        if (instance == null) {//DCL--Double Check Lock 双重检查锁,提高效率
            synchronized (Boss.class) {
                if (instance == null) {
                    instance = new Boss();
                    //1 在堆中开辟空间，属性默认值
                    //2 调用构造方法，给属性赋值
                    //3 把地址放入局部变量
                }
            }
        }
        return instance;
    }

}
