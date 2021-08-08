package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-08-08 16:39:32
 */
public class IsMatch19 {

	/**
	 * 动态规划
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		char[] cs = s.toCharArray();
		char[] cp = p.toCharArray();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		// 初始化首行
		for (int i = 2; i <= n; i += 2) {
			dp[0][i] = dp[0][i - 2] && cp[i - 1] == '*';
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (cp[j - 1] == '*') {
					dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && cp[j - 2] == cs[i - 1]
							|| (cp[j - 2] == '.' && dp[i - 1][j]);
				} else {
					if (cp[j - 1] == '.') {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						dp[i][j] = dp[i - 1][j - 1] && cs[i - 1] == cp[j - 1];
					}
				}
			}
		}
		return dp[n][m];
	}

}