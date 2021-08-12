package com.caleb.java.desginmode.singleton;

/**
 * @Date 2021/6/19 16:59
 * 单例第三种写法：静态内部类写法：没有线程安全问题，节省空间。
 */
public class SingleTon2 {
    private SingleTon2(){

    }
    //静态内部类不使用，不会加载。
    private static class Holder{
        private static SingleTon2 instance=new SingleTon2();
    }

    public static SingleTon2 getInstance(){
        return Holder.instance;
    }
}
