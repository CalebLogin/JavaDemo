package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-30 10:25:06
 * 
 *       买卖股票的最佳时机III
 * 
 *       给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 
 *       设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 
 *       注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 */
public class MaxProfit123 {

	/**
	 * 动态规划
	 * 
	 * 状态机
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int n = prices.length;
		// 表示在第i天，我最多可以交易j次，当前我没有持有股票（0）的最大利润以及我持有股票 (1) 的最大利润
		int[][][] dp = new int[n + 1][2][2];
		dp[0][0][0] = 0;
		dp[0][0][1] = Integer.MIN_VALUE;
		dp[0][1][0] = 0;
		dp[0][1][1] = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i - 1]);
			dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i - 1]);
			dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1] + prices[i - 1]);
			dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i - 1]);
		}
		return dp[n][1][0];
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}
}