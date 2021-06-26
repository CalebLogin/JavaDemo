package com.caleb.java.desginmode.singleton;

/**
 * @Date 2021/6/19 16:42
 */
public class TestBoss {
    public static void main(String[] args) {
//        Boss boss1=Boss.getInstance();
//        Boss boss2=Boss.getInstance();
//        Boss boss3=Boss.getInstance();
//        System.out.println(boss1.hashCode());
//        System.out.println(boss2.hashCode());
//        System.out.println(boss3.hashCode());

        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Boss boss = Boss.getInstance();
                    System.out.println(boss.hashCode());
                }
            }).start();
        }
    }
}
