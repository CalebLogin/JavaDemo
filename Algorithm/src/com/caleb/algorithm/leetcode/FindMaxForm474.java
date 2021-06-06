package com.caleb.algorithm.leetcode;

/**
 * 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * @author：hanzhigang
 * @Date : 2021/6/6 2:49 PM
 */
public class FindMaxForm474 {
    /**
     * 0，1背包问题
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {

        int len = strs.length;
        int[][] cnt = new int[len][2];
//        统计0，1个数
        for (int i = 0; i < len; i++) {
            int c0 = 0, c1 = 0;
            for (Character c : strs[i].toCharArray()) {
                if (c == '0') {
                    c0++;
                } else {
                    c1++;
                }
            }
            cnt[i][0] = c0;
            cnt[i][1] = c1;
        }
//        dp表示截止第k个字符串，背包能够承受m个0和n个1的最多的字符串个数
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int k = 1; k <= len; k++) {
            int s0 = cnt[k - 1][0], s1 = cnt[k - 1][1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[k][i][j] = dp[k - 1][i][j];
                    if (i >= s0 && j >= s1) {
                        dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][i - s0][j - s1] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];

    }

    public int findMaxForm1(String[] strs, int m, int n) {

        int len = strs.length;
        int[][] cnt = new int[len][2];
//        统计0，1个数
        for (int i = 0; i < len; i++) {
            int c0 = 0, c1 = 0;
            for (Character c : strs[i].toCharArray()) {
                if (c == '0') {
                    c0++;
                } else {
                    c1++;
                }
            }
            cnt[i][0] = c0;
            cnt[i][1] = c1;
        }
//        dp表示背包能够承受m个0和n个1的最多的字符串个数
//        去掉k因为只关心上一个字符的状态，所以每一次更新完之后都是上一个字符的状态，不需要再记录k
        int[][] dp = new int[m+1][n+1];
        for (int k = 0; k < len; k++) {
            int s0 = cnt[k][0], s1 = cnt[k][1];
            for (int i = m; i >= s0; i--) {
                for (int j = n; j >= s1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - s0][j - s1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] s = new String[]{"10", "1", "0"};
        FindMaxForm474 findMaxForm474 = new FindMaxForm474();
        System.out.println(findMaxForm474.findMaxForm(s, 1, 1));
    }
}
