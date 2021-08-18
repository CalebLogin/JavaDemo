package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-18 17:14:48
 * 
 *       最小路径和
 * 
 *       给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 *       说明：每次只能向下或者向右移动一步。
 * 
 */
public class MinPathSum64 {
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] dp1 = new int[n];
		int[] dp2 = new int[m];
		dp1[0] = grid[0][0];
		dp2[0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			dp2[i] = dp2[i - 1] + grid[i][0];
		}
		for (int i = 1; i < n; i++) {
			dp1[i] = dp1[i - 1] + grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			dp1[0] = dp2[i];
			for (int j = 1; j < n; j++) {
				dp1[j] = Math.min(dp1[j - 1], dp1[j]) + grid[i][j];
			}
		}
		return dp1[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
	}

}