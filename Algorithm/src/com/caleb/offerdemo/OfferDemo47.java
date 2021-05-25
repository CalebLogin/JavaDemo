package com.caleb.offerdemo;

/**
 * 礼物的最大价值
 * <p>
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * 思路1：动态规划的思想，dp[i][j] = num[i][j] + dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
 *
 * @author：hanzhigang
 * @Date : 2021/3/12 11:32 PM
 */
public class OfferDemo47 {

    public int maxValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i > 0 && j > 0) {
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                } else if (i > 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (j > 0) {
                    grid[i][j] += +grid[i][j - 1];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];

    }

    public static void main(String[] args) {
        OfferDemo47 offerDemo47 = new OfferDemo47();
        int[][] arr = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(offerDemo47.maxValue(arr));
    }
}
