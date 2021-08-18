package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-08-17 19:44:16
 * 
 *       最长递增子序列
 * 
 *       给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 
 *       子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组
 *       [0,3,1,6,2,2,7] 的子序列。
 */
public class LengthOfLIS300 {

	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int res = 0;
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

}