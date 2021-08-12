package com.caleb.java.desginmode.singleton;

/**
 * @Date 2021/6/19 16:33
 */
public class TestSingleTon {
    public static void main(String[] args) {
//        SingleTon singleTon1=SingleTon.getInstance();
//        SingleTon singleTon2=SingleTon.getInstance();
//        SingleTon singleTon3=SingleTon.getInstance();
//        System.out.println(singleTon1.hashCode());
//        System.out.println(singleTon2.hashCode());
//        System.out.println(singleTon3.hashCode());
        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleTon2 singleTon=SingleTon2.getInstance();
                    System.out.println(singleTon.hashCode());
                }
            }).start();
        }
    }
}
