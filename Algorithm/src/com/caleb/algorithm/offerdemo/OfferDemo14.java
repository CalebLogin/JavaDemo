package com.caleb.algorithm.offerdemo;

/**
 * 剪绳子
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 思路1：动态规划问题
 * 思路2：贪心算法
 *
 * @author：hanzhigang
 * @Date : 2021/3/4 10:29 AM
 */
public class OfferDemo14 {

    //
    int[] dp;

    public int cuttingRope(int n) {
        dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public int cuttingRope1(int n) {
        if (n <= 3) {
            return n - 1;
        }
//      a为倍数，b为余数
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;

    }


    public static void main(String[] args) {
        OfferDemo14 offerDemo14 = new OfferDemo14();
        System.out.println(offerDemo14.cuttingRope(10));
    }
}
