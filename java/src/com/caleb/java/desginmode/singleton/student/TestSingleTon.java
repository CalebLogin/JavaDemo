package com.caleb.java.desginmode.singleton.student;

/**
 * @Date 2021/6/21 10:04
 */
public class TestSingleTon {
    public static void main(String[] args) {
        SingleTon singleTon1=SingleTon.INSTANCE;
        SingleTon singleTon2=SingleTon.INSTANCE;
        SingleTon singleTon3=SingleTon.INSTANCE;
        System.out.println(singleTon1.hashCode());
        System.out.println(singleTon2.hashCode());
        System.out.println(singleTon3.hashCode());

    }
}
