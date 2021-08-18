package com.caleb.algorithm.review;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-08-17 22:23:43
 */
public class CanPartition416 {

	public boolean canPartition(int[] nums) {
		int total = 0;
		int n = nums.length;
		int maxNum = 0;
		Arrays.sort(nums);
		for (Integer i : nums) {
			total += i;
			maxNum = Math.max(maxNum, i);
		}
		if (total % 2 != 0) {
			return false;
		}
		if(maxNum > total / 2){
			return false;
		}
		boolean[][] dp = new boolean[n][total / 2 + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}
		dp[0][nums[0]] = true;
		for (int i = 1; i < n; i++) {
			int num = nums[i];
			for (int j = 0; j <= total / 2; j++) {
				if (j >= num) {
					dp[i][j] = dp[i - 1][j - num] | dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n - 1][total / 2];
	}

}