package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-08-29 23:37:38
 */
public class StoneGame877 {

	/**
	 * 区间DP问题 i j 表示 作为第一个拿的，能比后面拿的赢多少
	 * 
	 * @param piles
	 * @return
	 */
	public boolean stoneGame(int[] piles) {
		int n = piles.length;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = piles[i];
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				int left = piles[i] - dp[j];
				int right = piles[j] - dp[j - 1];
				dp[j] = Math.max(left, right);
			}
		}
		return dp[n - 1] > 0;
	}

}