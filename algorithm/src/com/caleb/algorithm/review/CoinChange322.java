package com.caleb.algorithm.review;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-08-16 16:15:21
 * 
 *       零钱兑换
 * 
 */
public class CoinChange322 {

	public int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		if (amount == -1) {
			return -1;
		}
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (Integer coin : coins) {
				if (coin > i) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}

}