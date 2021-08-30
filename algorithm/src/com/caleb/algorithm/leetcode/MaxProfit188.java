package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-30 14:11:16
 * 
 *       买卖股票的最佳时机IV
 * 
 *       给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 
 *       设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 
 *       注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 */
public class MaxProfit188 {

	/**
	 * 动态规划
	 * 
	 * 在当前阶段，穷举买入还是卖出，取得最大值
	 * 
	 * @param k
	 * @param prices
	 * @return
	 */
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n + 1][k + 1][2];
		for (int i = 0; i <= k; i++) {
			dp[0][i][0] = 0;
			dp[0][i][1] = Integer.MIN_VALUE;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = k; j >= 1; j--) {
				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
				dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
			}
		}
		return dp[n][k][0];
	}

}