package com.eric.offerdemo;

import java.math.BigDecimal;

/**
 * n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 回溯问题,也可以用dfs
 *
 * @author：hanzhigang
 * @Date : 2021/3/19 9:51 AM
 */
public class OfferDemo60 {
    int count = 0;

    /**
     * 实际上是给定几个数字，数字之和等于某个数，有多少种组合的问题
     *
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        // 会出现多少种结果
        int size = n * 6 - n + 1;
        // 返回的概率结果
        double[] res = new double[size];
        for (int i = 0; i <= size / 2; i++) {
            helper(i + n, n, 0);
            res[i] = new BigDecimal(count * Math.pow(1 / 6.0, n)).setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
            count = 0;
        }
        for (int i = size - 1; i > size / 2; i--) {
            res[i] = res[size - i - 1];
        }
        return res;
    }

    /**
     * @param num      当前要组合得到的值
     * @param n        当前组合的数字个数
     * @param curValue
     */
    public void helper(int num, int n, int curValue) {
        if (n == 1) {
            if (curValue + 6 >= num) { // 如果组合结果等于num，计数器++
                count++;
            }
            return;
        }

        for (int i = 1; i <= num - curValue - n + 1 && i <= 6; i++) { // i这里进行剪枝
            helper(num, n - 1, curValue + i);
        }

    }

    /**
     * 动态规划的思想
     * getCount(2,4) = getCount(1,1) + getCount(1,2) + getCount(1,3)
     *
     * @param n
     * @return
     */
    public double[] dicesProbability1(int n) {
        // 会出现多少种结果
        int size = n * 6 - n + 1;
        // 返回的概率结果
        double[] res = new double[size];
        // 状态函数数组
        int[][] dp = new int[n + 1][6 * n + 1];
        // 第一维数组每次出现的次数为1
        for (int i = 1; i <= 6; i++) {dp[1][i] = 1;}
        // 在两个骰子开始，计算每次出现的点数时其实就是之前符合条件的点数相加。
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6 && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        double total = Math.pow(6,n);

        for (int i = 0; i < res.length; i++) {
            System.out.println(dp[n][n+i]);
            res[i] = dp[n][n+i]/total;
        }


        return res;
    }


    public static void main(String[] args) {
        OfferDemo60 offerDemo60 = new OfferDemo60();
        double[] res = offerDemo60.dicesProbability1(2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
