package com.eric.offerdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 思路1：额外数组
 * 思路2：约瑟夫环
 *
 * @author：hanzhigang
 * @Date : 2021/3/20 9:34 PM
 */
public class OfferDemo62_ {
    public static int lastRemaining(int n, int m) {
        m-=1;
        int curIndex = 0;   // 当前位置为0
        List<Integer> list = new ArrayList<>();
        // 将值存入list中
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        while(list.size() > 1){
            int index = (curIndex+m)%list.size();
            list.remove((curIndex+m)%list.size());
            curIndex = (index) % list.size();
        }
        return list.get(0);

    }
    public static int lastRemaining1(int n, int m) {
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(10, 17));
    }
}
