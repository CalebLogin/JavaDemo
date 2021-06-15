package com.caleb.algorithm.dynamicplanning;

/**
 * 01背包问题
 * 
 * @author:Caleb
 * @Date :2021-06-15 13:05:31
 */
public class Ksnapsack01 {

	/**
	 * 基本解法
	 * 
	 * @param weight
	 * @param values
	 * @return
	 */
	public int ksnapsack(int[] weight, int[] values, int w) {
		int len = weight.length;
		/**
		 * 表示的含义为截止到第i个物品，重量为j的包装下的最大价值为多少
		 */
		int[][] dp = new int[len + 1][w + 1];
		for (int i = 1; i < len; i++) {
			for (int j = 0; j <= w; j++) {
				/**
				 * 包含第i个物品与不包含第i个物品的最大值
				 */
				if (j < weight[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + values[i - 1]);
				}
			}
		}
		return dp[len][w];
	}

	/**
	 * 滚动数组
	 * 
	 * @param weight
	 * @param values
	 * @param w
	 * @return
	 */
	public int ksnapsack1(int[] weight, int[] values, int w) {

		int len = weight.length;
		int[] dp = new int[w + 1];
		for (int i = 0; i < len; i++) {
			for (int j = w; j >= weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
			}
		}
		return dp[w];

	}

}
