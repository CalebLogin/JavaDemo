package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-16 18:18:15
 * 
 *       编辑距离
 * 
 *       给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 
 *       你可以对一个单词进行如下三种操作：
 * 
 *       插入一个字符 删除一个字符 替换一个字符
 * 
 */
public class MinDistance72 {

	/**
	 * 插入、删除、替换
	 * 动态规划
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		char[] s1 = word1.toCharArray();
		char[] s2 = word2.toCharArray();
		int[][] dp = new int[s1.length + 1][s2.length + 1];
		for (int i = 0; i <= s2.length; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i <= s1.length; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= s1.length; i++) {
			for (int j = 1; j <= s2.length; j++) {
				if (s1[i - 1] == s2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					/**
					 * 插入，删除，替换
					 */
					dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
				}
			}
		}
		return dp[s1.length][s2.length];
	}

}