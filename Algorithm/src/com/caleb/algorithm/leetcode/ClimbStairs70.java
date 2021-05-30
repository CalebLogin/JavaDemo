package com.caleb.algorithm.leetcode;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @author：hanzhigang
 * @Date : 2021/4/9 6:50 PM
 */
public class ClimbStairs70 {
    /**
     * 动态规划的思想
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for(int i = 0;i<n;i++){
            int temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}
