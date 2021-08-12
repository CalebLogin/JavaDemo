package com.caleb.algorithm.leetcode;

/**
 * 分割等和子集 给你一个只包含正整数的非空数组nums。 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 * @author:Caleb
 * @Date :2021-06-15 15:05:24
 */
public class CanPartition416 {

	/**
	 * 0，1背包问题
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canPartition(int[] nums) {
		int count = 0;
		int len = nums.length;
		for (int num : nums) {
			count += num;
		}
		if (count % 2 == 1) {
			return false;
		}
		count /= 2;
		/**
		 * 放入第i个数最大总和为j
		 */
		int[] dp = new int[count + 1];
		for (int i = 0; i < len; i++) {
			for (int j = count; j >= nums[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
			}
		}
		return dp[count] == count;
	}

	/**
	 * 0，1背包问题
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canPartition1(int[] nums) {
		int count = 0;
		int len = nums.length;
		if (len < 2) {
			return false;
		}
		for (int num : nums) {
			count += num;
		}
		if (count % 2 == 1) {
			return false;
		}
		count /= 2;
		/**
		 * 表示在前i个数中选取若干个数，是否可能使其和为j
		 */
		boolean[] dp = new boolean[count + 1];
		// 在前i个数中选取若干个数，存在
		dp[0] = true;
		for (int i = 0; i < len; i++) {
			for (int j = count; j >= nums[i]; j--) {
				dp[j] |= dp[j - nums[j]];
			}
		}
		return dp[count];
	}

}