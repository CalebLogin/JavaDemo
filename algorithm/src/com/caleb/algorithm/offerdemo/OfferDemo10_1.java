package com.caleb.algorithm.offerdemo;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
 *
 * @author：hanzhigang
 * @Date : 2021/3/2 1:45 PM
 */
public class OfferDemo10_1 {

    //类似斐波那契数列解法
    public int numWays(int n) {
//      设置初始值
        int a =1,b=1,num;
        for(int i=0;i<n;i++){
            num = (a+b)%1000000007;
            a = b;
            b = num;
        }
        return a;
    }

//  动态规划解法
    public int numWays1(int n){

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[n] = (dp[n-1]+dp[n-2])%1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
