package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-08-25 22:39:48
 * 
 *       正则表达式匹配
 * 
 *       给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * 
 *       '.' 匹配任意单个字符 '*' 匹配零个或多个前面的那一个元素 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 
 */
public class IsMatch10 {
	public boolean isMatch(String s, String p) {
		int lenS = s.length();
		int lenP = p.length();
		char[] ss = s.toCharArray();
		char[] sp = p.toCharArray();
		boolean[][] dp = new boolean[lenS + 1][lenP + 1];
		dp[0][0] = true;
		for (int i = 2; i <= lenP; i += 2) {
			dp[0][i] = dp[0][i - 2] && sp[i - 1] == '*';
		}
		for (int i = 1; i <= lenS; i++) {
			for (int j = 1; j <= lenP; j++) {
				if (sp[j - 1] == '*') {
					dp[i][j] = (dp[i - 1][j] && (sp[j - 2] == '.' || ss[i - 1] == sp[j - 2])) || dp[i][j - 2];
				} else {
					if (sp[j - 1] == '.') {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						dp[i][j] = sp[j - 1] == ss[i - 1] && dp[i - 1][j - 1];
					}
				}
			}
		}
		return dp[lenS][lenP];

	}
}