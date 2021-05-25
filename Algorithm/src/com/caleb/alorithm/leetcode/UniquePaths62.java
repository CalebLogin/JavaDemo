package com.caleb.alorithm.leetcode;

/**
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 *
 * @author：hanzhigang
 * @Date : 2021/4/9 6:15 PM
 */
public class UniquePaths62 {

    /**
     * 利用动态规划算法
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];    // 新建m x n的数组

        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] += res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m-1][n-1];


    }
}
