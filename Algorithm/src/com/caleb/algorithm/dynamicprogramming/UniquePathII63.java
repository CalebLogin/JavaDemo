package com.caleb.algorithm.dynamicprogramming;

/**
 * @author：hanzhigang
 * @Date : 2021/3/23 11:47 PM
 */
public class UniquePathII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 定义状态数组
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 将第一行和第一列置为1，有障碍的话后面的为0
        for (int i = 0; i < dp.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }else{
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < dp[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }else{
                dp[0][j] = 1;
            }
        }
        // 依次遍历路径，只计算不存在障碍物的地方，存在障碍物的地方为0
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        // 返回结果
        return dp[dp.length-1][dp[0].length-1];
    }

    /**
     * 利用滚动数组来做，空间复杂度也降低
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        return 0;
    }
}
