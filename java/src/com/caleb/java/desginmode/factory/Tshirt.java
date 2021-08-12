package com.caleb.java.desginmode.factory;

/**
 * @Date 2021/6/19 15:57
 */
public class Tshirt extends Clothes {
    @Override
    void prepare() {
        System.out.println("开始准备T恤的材料");
    }

    @Override
    void make() {
        System.out.println("开始制作T恤");
    }

    @Override
    void box() {
        System.out.println("开始打包T恤");
    }
}
