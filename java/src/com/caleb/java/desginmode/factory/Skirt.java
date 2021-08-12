package com.caleb.java.desginmode.factory;

/**
 * @Date 2021/6/19 16:08
 */
public class Skirt extends Clothes {
    @Override
    void prepare() {
        System.out.println("准备裙子");
    }

    @Override
    void make() {
        System.out.println("制作裙子");
    }

    @Override
    void box() {
        System.out.println("打包裙子");
    }
}
