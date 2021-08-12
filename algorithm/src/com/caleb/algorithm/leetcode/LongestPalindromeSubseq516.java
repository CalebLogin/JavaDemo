package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-12 21:58:01
 * 
 *       最长回文子序列
 * 
 *       给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 
 *       子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class LongestPalindromeSubseq516 {

	/**
	 * 动态规划
	 * 
	 * @param s
	 * @return
	 */
	public int longestPalindromeSubseq(String s) {
		char[] cs = s.toCharArray();
		int n = cs.length;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (cs[i] == cs[j]) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		return dp[0][n - 1];

	}

}