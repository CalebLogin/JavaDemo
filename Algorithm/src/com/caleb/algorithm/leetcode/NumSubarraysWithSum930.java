package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.caleb.demo.countNum;

/**
 * @author:Caleb
 * @Date :2021-07-08 16:56:57
 * 
 *       和相同的二元子数组
 * 
 *       给你一个二元数组nums，和一个整数goal，请你统计并返回有多少个和为goal的非空子数组。
 * 
 *       子数组是数组的一段连续部分。
 * 
 *       1 <= nums.length <= 3 * 104
 * 
 *       nums[i] 不是 0 就是 1
 * 
 *       0 <= goal <= nums.length
 */

public class NumSubarraysWithSum930 {

	/**
	 * 朴素
	 * 
	 * @param nums
	 * @param goal
	 * @return
	 */
	public int numSubarraysWithSum(int[] nums, int goal) {
		int len = nums.length;
		int[] dp = new int[len];
		int res = 0, i = 0;
		if (goal == 0) {
			while (i < len) {
				if (goal != nums[i]) {
					dp[i++] = 0;
				} else {
					dp[i++] = 1;
					break;
				}
			}
		} else {
			while (i < len) {
				res += nums[i];
				if (res == goal) {
					int j = i;
					int tempRes = 0;
					res = 0;
					while (j >= 0) {
						res += nums[j];
						if (res == goal) {
							break;
						} else {
							j--;
						}
					}
					if (res == goal) {
						tempRes++;
						j--;
						while (j >= 0) {
							if (res + nums[j] == goal) {
								tempRes++;
							} else {
								break;
							}
							j--;
						}
					}
					dp[i++] = tempRes;
					break;
				} else {
					dp[i++] = 0;
				}
			}
		}
		if (res != goal) {
			return 0;
		}
		for (; i < len; i++) {
			int tempRes = 0;
			res = 0;
			int j = i;
			while (j >= 0) {
				res += nums[j];
				if (res == goal) {
					break;
				} else {
					j--;
				}
			}
			if (res == goal) {
				tempRes++;
				j--;
				while (j >= 0) {
					res += nums[j];
					if (res == goal) {
						tempRes++;
					} else {
						break;
					}
					j--;
				}
			}
			dp[i] = dp[i - 1] + tempRes;
		}
		return dp[len - 1];
	}

	/**
	 * 滑动窗口
	 * 
	 * @param nums
	 * @param goal
	 * @return
	 */
	public int numSubarraysWithSum1(int[] nums, int goal) {
		int res = 0;
		int left1 = 0, left2 = 0, right = 0;
		int sum1 = 0, sum2 = 0;
		int len = nums.length;
		while (right < len) {
			sum1 += nums[right];
			while (left1 <= right && sum1 > goal) {
				sum1 -= nums[left1];
				left1++;
			}
			sum2 += nums[right];
			while (left2 <= right && sum2 >= goal) {
				sum2 -= nums[left2];
				left2++;
			}
			res += left2 - left1;
			right++;
		}
		return res;
	}

	/**
	 * 前缀和
	 * 
	 * sum[j] - sum[j] = goal
	 * 
	 * @param nums
	 * @param goal
	 * @return
	 */
	public int numSubarraysWithSum2(int[] nums, int goal) {
		int sum = 0;
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : nums) {
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			sum += i;
			res += map.getOrDefault(sum - goal, 0);
		}
		return res;
	}

	public static void main(String[] args) {
		NumSubarraysWithSum930 n = new NumSubarraysWithSum930();
		System.out.println(n.numSubarraysWithSum(new int[] { 0, 1, 1, 1, 1 }, 3));
	}

}