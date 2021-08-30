package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-30 14:31:44
 * 
 *       买卖股票的最佳时机，含手续费
 * 
 *       给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 
 *       你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 
 *       返回获得利润的最大值。
 * 
 *       注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 
 */
public class MaxProfit714 {

	/**
	 * 动态规划
	 * 
	 * 0 表示 没有持有股票，1 表示 持有股票
	 * 
	 * @param prices
	 * @param fee
	 * @return
	 */
	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		int[][] dp = new int[n + 1][2];
		dp[0][0] = 0;
		dp[0][1] = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1] - fee);	
		}
		return dp[n][0];
	}

	public static void main(String[] args) {
		MaxProfit714 m = new MaxProfit714();
		int pro = m.maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }, 2);
		System.out.println(pro);
	}

}