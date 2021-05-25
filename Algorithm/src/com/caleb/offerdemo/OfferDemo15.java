package com.caleb.offerdemo;

/**
 * 二进制中1的个数
 * <p>
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * @author：hanzhigang
 * @Date : 2021/3/4 11:34 AM
 */
public class OfferDemo15 {

    public int hammingWeight(int n) {
//      统计1的个数
        int res = 0;

        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight1(int n) {

//      统计1的个数
        int res = 0;

        while (n != 0) {
            res++;
//          二进制数字 n 最右边的 1 变成 0 ，其余不变。
            n &= (n-1);
        }
        return res;
    }


    public static void main(String[] args) {
        String a = String.valueOf(00000000000000000000000000001011);
        System.out.println(a);
    }
}
