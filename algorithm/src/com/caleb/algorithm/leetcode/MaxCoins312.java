package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-29 22:29:51
 * 
 *       戳气球
 * 
 *       有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 
 *       现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1]
 *       枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1
 *       超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 
 *       求所能获得硬币的最大数量。
 */
public class MaxCoins312 {

	/**
	 * 回溯
	 * 
	 * @param nums
	 * @return
	 */
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int[] anNums = new int[n + 2];
		anNums[0] = 1;
		anNums[n + 1] = 1;
		for (int i = 0; i < n; i++) {
			anNums[i + 1] = nums[i];
		}
		return dp(anNums, nums.length);
	}

	public int dp(int[] nums, int left) {
		if (left == 0) {
			return 0;
		}
		int maxRes = Integer.MIN_VALUE;
		int i = 1;
		for (; i <= nums.length; i++) {
			if (nums[i] != -1) {
				int l = i - 1;
				int r = i + 1;
				while (l >= 0 && nums[l] == -1) {
					l--;
				}
				while (r < nums.length + 2 && nums[r] == -1) {
					r++;
				}
				int finalRes = nums[i] * nums[l] * nums[r];
				int temp = nums[i];
				nums[i] = -1;
				int nextMax = dp(nums, left - 1);
				nums[i] = temp;
				maxRes = Math.max(maxRes, nextMax + finalRes);
			}
		}
		return maxRes;
	}

	/**
	 * 区间dp，i 和 j 之间(开区间)戳破气球得到的最大值
	 * 
	 * @param nums
	 * @return
	 */
	public int maxCoins1(int[] nums) {
		int n = nums.length;
		int[] anNums = new int[n + 2];
		anNums[0] = 1;
		anNums[n + 1] = 1;
		for (int i = 0; i < n; i++) {
			anNums[i + 1] = nums[i];
		}
		int[][] dp = new int[n + 2][n + 2];
		for (int i = n + 1; i >= 0; i--) {
			for (int j = i + 2; j <= n + 1; j++) {
				for (int k = i + 1; k < j; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + anNums[i] * anNums[k] * anNums[j]);
				}
			}
		}
		return dp[0][n + 1];
	}
}