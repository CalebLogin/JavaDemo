package com.caleb.algorithm.leetcode;

/**
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * @author：hanzhigang
 * @Date : 2021/5/31 11:50 PM
 */
public class NumSquares279 {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int ns = (int) Math.sqrt(n);
        int[] squareNum = new int[ns + 1];
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 0; i <= ns; i++) {
            squareNum[i] = (i) * (i);
        }
        for (int i = 1; i <= n; i++) {
            int s = (int) Math.sqrt(i);
            dp[i] = i;
            for (int j = 1; j <= s; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares279 numSquares279 = new NumSquares279();
        System.out.println(numSquares279.numSquares(13));
    }
}
