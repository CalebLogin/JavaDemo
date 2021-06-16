package com.caleb.algorithm.leetcode;

/**
 * 石子游戏 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
 * 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 * 
 * @author:Caleb
 * @Date :2021-06-16 10:32:11
 */
public class StoneGame877 {

	public boolean stoneGame(int[] piles) {
		int len = piles.length;

		// dp[i][j]表示当剩下的石子堆为下标i到下标j时，当前玩家与另一个玩家的石子数量之差的最大值。
		// i > j没有意义，所以dp[i][j] = 0
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = piles[i];
		}
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				int a = piles[i] - dp[i + 1][j];
				int b = piles[j] - dp[i][j - 1];
				dp[i][j] = Math.max(a, b);
			}
		}

		return dp[0][len - 1] > 0;
	}

	/**
	 * 优化后的动态规划
	 * 
	 * @param piles
	 * @return
	 */
	public boolean stoneGame1(int[] piles) {
		int len = piles.length;

		// dp[i][j]表示当剩下的石子堆为下标i到下标j时，当前玩家与另一个玩家的石子数量之差的最大值。
		// i > j没有意义，所以dp[i][j] = 0
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			dp[i] = piles[i];
		}

		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				int a = piles[i] - dp[j];
				int b = piles[j] - dp[j - 1];
				dp[j] = Math.max(a, b);
			}
		}

		return dp[len - 1] > 0;
	}

}