package com.caleb.algorithm.offerdemo;

/**
 * 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * n+1 左移log2(n)
 * n
 * /2
 * 思路：位运算
 */
public class OfferDemo64 {
    public static int sumNums(int n) {
        return  ((n+1) >> (n&1)) * (n >> ((n+1)&1));
    }

    public static int sumNums1(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }


    public static void main(String[] args) {
        System.out.println(sumNums1(5));
    }
}
