package com.caleb.offerdemo;

/**
 * 数值的整数次方
 * <p>
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * @author：hanzhigang
 * @Date : 2021/3/4 12:57 PM
 */
public class OfferDemo16 {

    double res = 1.0;

    //  二分法来求数值的整数次方
    public double myPow(double x, int n) {

//      将n改为long类型，防止数字溢出问题
//      Integer.MIN_VALUE的相反数是其本身
        long b = n;

        if (x == 0) return 0;
//      如果b小于0，把它改为整数
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
//          b是奇数，需要乘上该位上的权重
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public double myPow1(double x, int n) {

        if (x == 0) return 0;
        for (int i = n; i != 0; i /= 2, x *= x) {
            // 最后一位为1，需要乘上该位上的权重
            if ((i & 1) == 1) res *= x;
        }
        return n < 0 ? 1.0 / res : res;
    }

    public double myPow2(double x, int n) {
        if (n == 0) return 1;
//      如果n是负数，将其x变为倒数，n取相反数，防止数字溢出，提取一个1/x
        if (n < 0) {
            return 1 / x * myPow2(1 / x, -n - 1);
        }
        return ((n & 1) == 1) ? x * myPow2(x * x, n / 2) : myPow2(x * x, n / 2);
    }

    public static void main(String[] args) {
        OfferDemo16 offerDemo16 = new OfferDemo16();
        System.out.println(offerDemo16.myPow(2.0000, -2));
    }

}
