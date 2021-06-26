package com.caleb.java.desginmode.factory;

import java.util.Scanner;

/**
 * @Date 2021/6/19 16:01
 */
public class TestFactory {
    public static void main(String[] args) {
        System.out.println("------欢迎进入树桐服装厂--------");
        System.out.println("--------1 裤子 2 T恤 3夹克----------");
        Scanner input=new Scanner(System.in);
        int type=input.nextInt();
        Clothes clothes = ClothesFactory.createClothes(type);
        if(clothes!=null){
            System.out.println("购买成功");
        }else{
            System.out.println("购买失败");
        }
    }
}
