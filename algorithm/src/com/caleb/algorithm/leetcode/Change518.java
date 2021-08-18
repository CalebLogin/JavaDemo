package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-17 23:10:40
 * 
 *       零钱兑换II
 * 
 *       给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 
 *       请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 
 *       假设每一种面额的硬币有无限个。 
 * 
 *       题目数据保证结果符合 32 位带符号整数。
 */
public class Change518 {

	public int change(int amount, int[] coins) {
		int n = coins.length;
		int[][] dp = new int[n + 1][amount + 1];
		int currAmount = coins[0];
		for (int j = 0; j <= n; j++) {
			dp[j][0] = 1;
		}
		for (int j = 1; j <= n; j++) {
			currAmount = coins[j - 1];
			for (int k = 1; k <= amount; k++) {
				dp[j][k] = dp[j - 1][k];
				if (k - currAmount >= 0) {
					dp[j][k] += dp[j][k - currAmount];
				}

			}

		}
		return dp[n][amount];
	}

	public int change1(int amount, int[] coins) {
		int n = coins.length;
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			int currAmount = coins[i];
			for (int j = 1; j <= amount; j++) {
				if (j >= currAmount) {
					dp[j] += dp[j - currAmount];
				}

			}
		}
		return dp[amount];
	}

}