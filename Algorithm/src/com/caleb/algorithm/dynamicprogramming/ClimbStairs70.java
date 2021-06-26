package com.caleb.algorithm.dynamicprogramming;

/**
 * 爬楼梯70
 * 使用动态规划思想
 *
 * @author：hanzhigang
 * @Date : 2021/3/23 8:56 PM
 */
public class ClimbStairs70 {
    public int climbStairs(int stage) {
        int a = 1, b = 1;
        for (int i = 1; i <= stage; i++){
            int temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        ClimbStairs70 climbStairs70 = new ClimbStairs70();
        System.out.println(climbStairs70.climbStairs(3));
    }
}
