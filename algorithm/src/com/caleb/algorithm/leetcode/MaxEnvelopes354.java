package com.caleb.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:Caleb
 * @Date :2021-08-17 20:00:45
 * 
 *       俄罗斯套娃信封问题
 * 
 *       给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 
 *       当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 
 *       请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 
 *       注意：不允许旋转信封。
 */
public class MaxEnvelopes354 {

	public int maxEnvelopes(int[][] envelopes) {
		int res = 0;
		// 对w进行升序排序，相同的w对h进行降序排序
		Arrays.sort(envelopes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}

		});
		int m = envelopes.length;
		int[] dp = new int[m];
		dp[0] = 1;
		for (int i = 0; i < m; i++) {
			int w = envelopes[i][0];
			int h = envelopes[i][1];
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				int w1 = envelopes[j][0];
				int h1 = envelopes[j][1];
				if (w1 < w && h1 < h) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

}