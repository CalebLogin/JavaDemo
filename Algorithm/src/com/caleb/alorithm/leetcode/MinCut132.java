package com.caleb.alorithm.leetcode;

import java.util.Arrays;

/**
 * 分割回文串II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 * <p>
 * 思路1：预处理加回溯 超时
 * 思路2：预处理加动态规划
 *
 * @author：hanzhigang
 * @Date : 2021/4/12 9:23 PM
 */
public class MinCut132 {
    private boolean[][] f;
    private int n;
    private int min = Integer.MAX_VALUE;
    private int count = 0;

    public int minCut(String s) {
        n = s.length();
        char[] c = s.toCharArray();
        f = new boolean[n][n];
        // 将 f 全部置为true
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        // 进行预处理，找出是回文串的i,j
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = c[i] == c[j] && f[i + 1][j - 1];
            }
        }
        helper(0);

        return min;
    }

    public void helper(int i) {
        if (i == n) {
            min = Math.min(min, count - 1);
            return;
        }
        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                ++count;
                helper(j + 1);
                --count;
            }
        }
    }


    /**
     * 预处理加动态规划的思想
     *
     * @param s
     * @return
     */
    public int minCut1(String s) {
        n = s.length();
        char[] c = s.toCharArray();
        f = new boolean[n][n];
        int[] dp = new int[n];

        // 将 f 全部置为true
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        // 将 dp 全部置为最大值
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 进行预处理，找出是回文串的i,j
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = c[i] == c[j] && f[i + 1][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            // 如果当前 0,i 是回文串，则不用分割
            if (f[0][i]) {
                dp[i] = 0;
            } else {
                // 寻找之前的最小切割数
                for (int j = 0; j < i; j++) {
                    if (f[j + 1][i]) {
                        dp[i] = Math.min(dp[j] + 1, dp[i]);
                    }
                }
            }
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {
        String res = "ab";
        MinCut132 minCut132 = new MinCut132();
        System.out.println(minCut132.minCut1(res));
    }

}
