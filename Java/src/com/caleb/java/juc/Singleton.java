package com.caleb.java.juc;

/**
 * @author：hanzhigang
 * @Date : 2021/2/24 9:10 PM
 */
public class Singleton {

    private Singleton(){}

    private static volatile Singleton singleton = null;

    private static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
