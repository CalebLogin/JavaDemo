package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * 零钱兑换 给定不同面额的硬币 coins 和一个总金额 amount。 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。 你可以认为每种硬币的数量是无限的。
 * 
 * @author:Caleb
 * @Date :2021-06-11 19:41:07
 */
public class CoinChange322 {

	/**
	 * 动态规划
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		int len = coins.length;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		Arrays.sort(coins);
		for (int k = 1; k <= amount; k++) {
			for (int i = 0; i < len && k - coins[i] >= 0; i++) {
				dp[k] = Math.min(dp[k],dp[k - coins[i]] + 1);
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		CoinChange322 change322 = new CoinChange322();
		System.out.println(change322.coinChange(new int[] { Integer.MAX_VALUE }, 0));
	}

}