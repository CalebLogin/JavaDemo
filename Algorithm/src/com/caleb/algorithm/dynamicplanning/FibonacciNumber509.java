package com.caleb.algorithm.dynamicplanning;

/**
 * F(0) = 0 F(1) = 1 F(2) = F(1) + F(0)
 * 使用动态规划的思想做
 * 返回第N个的值
 *
 * @author：hanzhigang
 * @Date : 2021/3/23 8:47 PM
 */
public class FibonacciNumber509 {

    public int fib(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        FibonacciNumber509 fibonacciNumber = new FibonacciNumber509();
        System.out.println(fibonacciNumber.fib(30));
    }
}
