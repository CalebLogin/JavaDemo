package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-07-17 22:21:01
 * 
 *       连续子数组的最大和
 * 
 *       输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 
 *       要求时间复杂度为O(n)。
 * 
 * 
 * 
 */
public class MaxSubArrayOffer42 {

	/**
	 * 动态规划
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {

		int maxVal = Integer.MIN_VALUE;
		int val = 0;
		for (int i = 0; i < nums.length; i++) {
			val = Math.max(val + nums[i], nums[i]);
			maxVal = Math.max(val, maxVal);
		}
		return maxVal;
	}

	/**
	 * 前缀和
	 * @param nums
	 * @return
	 */
	public int maxSubArray1(int[] nums) {

		int maxVal = Integer.MIN_VALUE;
		int min = 0;
		int val = 0;
		for (int i = 0; i < nums.length; i++) {
			val += nums[i];
			maxVal = Math.max(val - min, maxVal);
			if(val < min){
				min = val;
			}
		}
		return maxVal;
	}

	public static void main(String[] args) {
		MaxSubArrayOffer42 m = new MaxSubArrayOffer42();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(m.maxSubArray(nums));
	}

}