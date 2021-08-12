package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-07-24 13:56:26
 * 
 *       划分为k个相等的子集
 * 
 *       给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 */
public class CanPartitionKSubsets698 {

	int[] cnt;

	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k == 0) {
			return false;
		}
		if (k == 1) {
			return true;
		}
		cnt = new int[k];
		Arrays.sort(nums);
		int totalCount = 0;
		for (Integer i : nums) {
			totalCount += i;
		}
		if (totalCount % k != 0) {
			return false;
		}
		return dfs(nums, nums.length - 1, k, totalCount / k);
	}

	private boolean dfs(int[] nums, int index, int k, int num) {
		if (index == -1) {
			boolean flag = true;
			for (int i = 1; i < k; i++) {
				if (cnt[i - 1] != cnt[i]) {
					flag = false;
					break;
				}
			}
			return flag;
		}

		// 剪枝
		for (int i = 0; i < k; i++) {
			if (cnt[i] > num || (i > 0 && (cnt[i - 1] == cnt[i]))) {
				continue;
			}
			cnt[i] += nums[index];
			if (dfs(nums, index - 1, k, num)) {
				return true;
			}
			cnt[i] -= nums[index];
		}
		return false;
	}

	boolean[] visited;

	/**
	 * 一共k个数组，采用每次都去寻找和为指定值的数组，存在的话继续寻找下一个，直到还剩下一个数组为止，则当前肯定存在符合条件的数组
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean canPartitionKSubsets1(int[] nums, int k) {
		if (k == 1) {
			return true;
		}
		int totalCount = 0;
		for (Integer num : nums) {
			totalCount += num;
		}
		visited = new boolean[nums.length];
		if (totalCount % k != 0) {
			return false;
		}
		Arrays.sort(nums);
		return dfs1(nums, nums.length - 1, totalCount / k, k, 0);

	}

	private boolean dfs1(int[] nums, int start, int num, int k, int currVal) {

		// 剪枝，当只剩下一个数组时，说明前 k-1 个数组都符合了条件，剩下的这一个数组也肯定符合条件
		if (k == 1) {
			return true;
		}

		// 如果当前数组的和等于指定的值，说明当前数组符合条件，寻找下一个数组。
		if (currVal == num) {
			return dfs1(nums, nums.length - 1, num, k - 1, 0);
		}

		for (int i = start; i >= 0; i--) {
			// 剪枝
			if (visited[i]) {
				continue;
			}
			if (currVal + nums[i] > num) {
				continue;
			}
			visited[start] = true;
			if (dfs1(nums, i - 1, num, k, currVal + nums[i])) {
				return true;
			}
			visited[start] = false;
			// 剪枝
			while (i > 0 && nums[i] == nums[i - 1]) {
				i--;
			}
		}

		return false;

	}

}