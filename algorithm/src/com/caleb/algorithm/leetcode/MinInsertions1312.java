package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-30 15:17:48
 * 
 *       让字符串成为回文串的最少插入次数
 * 
 *       给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 * 
 *       请你返回让 s 成为回文串的 最少操作次数 。
 * 
 *       「回文串」是正读和反读都相同的字符串。
 */
public class MinInsertions1312 {

	/**
	 * 动态规划
	 * 
	 * i 和 j 表示 在 i j 之间成为回文串的最少操作次数
	 * @param s
	 * @return
	 */
	public int minInsertions(String s) {
		char[] cs = s.toCharArray();
		int n = cs.length;
		int[][] dp = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (cs[i] == cs[j]) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		return dp[0][n-1];
	}

}