package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-17 21:56:01
 * 
 *       两个字符串的最小ASCII删除和
 * 
 *       给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 * 
 */
public class MinimumDeleteSum712 {

	/**
	 * 使用LCS
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int minimumDeleteSum(String s1, String s2) {
		int s1T = 0;
		int s2T = 0;
		for (int i = 0; i < s1.length(); i++) {
			s1T += s1.charAt(i);
		}
		for (int i = 0; i < s2.length(); i++) {
			s2T += s2.charAt(i);
		}
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j]));
				}
			}
		}
		return s1T + s2T - 2 * dp[m][n];

	}

}