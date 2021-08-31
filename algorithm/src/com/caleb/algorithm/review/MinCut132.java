package com.caleb.algorithm.review;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-08-31 16:43:45
 */
public class MinCut132 {

	public int minCut(String s) {
		char[] cs = s.toCharArray();
		int n = cs.length;
		boolean[][] dp = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], true);
		}
		// 预处理
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				dp[i][j] = dp[i + 1][j - 1] && cs[i] == cs[j];
			}
		}
		int[] minSplit = new int[n];
		Arrays.fill(minSplit, Integer.MAX_VALUE);
		for (int i = 0; i < n; i++) {
			if(dp[0][i]){
				minSplit[i] = 0;
			}else{
				for (int j = 0; j < i; j++) {
					if (dp[i][j]) {
						minSplit[i] = Math.min(minSplit[j] + 1, minSplit[i]);
					}
				}
			}	
		}
		return minSplit[n - 1];
	}

	public static void main(String[] args) {
		MinCut132 m = new MinCut132();
		System.out.println(m.minCut("aab"));
	}
}