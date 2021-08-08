package com.caleb.algorithm.offerdemo;

/**
 * @author：hanzhigang
 * @Date : 2021/3/2 1:18 PM
 */
public class OfferDemo10 {
    public int fib(int n) {

//      记录两个前驱值
        int fib1 = 0, fib2 = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (fib1 + fib2) % 1000000007;
            fib1 = fib2;
            fib2 = sum;
        }
        return fib1;

    }

    public static void main(String[] args) {
        OfferDemo10 offerDemo10 = new OfferDemo10();
        System.out.println(offerDemo10.fib(22));
    }
}
