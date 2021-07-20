package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-07-20 09:12:33
 * 
 *       数组中最大数对和的最小值
 * 
 *       一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
 * 
 *       比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5,
 *       8) = 8 。 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
 * 
 *       nums 中每个元素 恰好 在 一个 数对中，且 最大数对和 的值 最小 。 请你在最优数对划分的方案下，返回最小的 最大数对和 。
 * 
 */
public class MinPairSum1877 {

	/**
	 * 贪心
	 * 
	 * @param nums
	 * @return
	 */
	public int minPairSum(int[] nums) {

		// 先进行排序
		Arrays.sort(nums);
		int i = 0, j = nums.length - 1;
		int min = Integer.MIN_VALUE;
		while (i < j) {
			min = Math.min(min, nums[i++] + nums[j--]);
		}
		return min;
	}

}