package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-07-19 16:02:27
 * 
 *       最高频元素的频数
 * 
 *       元素的 频数 是该元素在一个数组中出现的次数。
 * 
 *       给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 
 *       执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 */
public class MaxFrequency1838 {

	/**
	 * 暴力，超时
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
		int maxV = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = k;
			int j = i - 1;
			while (j >= 0 && count > 0) {
				if ((count -= (nums[i] - nums[j])) >= 0) {
					j--;
				}
				maxV = Math.max(maxV, i - j);
			}
		}
		return maxV;
	}

	/**
	 * 双指针
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxFrequency1(int[] nums, int k) {
		
		int l = 0, r = 0;
		int maxCount = 0;
		int size = nums.length;
		Arrays.sort(nums);
		int totalNum = 0;
		
		while(r < size){
			while(l <= r && (r - l) * nums[r] - totalNum > k){
				totalNum -= nums[l++];
			}
			maxCount = Math.max(maxCount, (r - l + 1));
			totalNum += nums[r++];
		}
		
		return maxCount;

	}

	public static void main(String[] args) {
		MaxFrequency1838 m = new MaxFrequency1838();
		System.out.println(m.maxFrequency1(new int[] { 1,4,8,13}, 5));
	}

}