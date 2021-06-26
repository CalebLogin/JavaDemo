package com.caleb.algorithm.dynamicprogramming;

/**
 * 不同路径
 * 一个机器人位于m x n网格的左上角，机器人每次只能向下或向右移动一步，机器人试图达到网格的右下角
 * 问总共有多少条不同的路径？
 *
 * @author：hanzhigang
 * @Date : 2021/3/23 9:25 PM
 */
public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int j = 0;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths62 uniquePaths62 = new UniquePaths62();
        System.out.println(uniquePaths62.uniquePaths(3, 3));
    }
}

