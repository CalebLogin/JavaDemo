package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-08-04 14:22:43
 * 
 *       有效三角形的个数
 * 
 *       给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * 
 */
public class TriangleNumber611 {

	/**
	 * 双指针
	 * 
	 * @param nums
	 * @return
	 */
	public static int triangleNumber(int[] nums) {
		// 返回结果个数
		int res = 0;
		Arrays.sort(nums);
		int l = 0, r = nums.length - 1;
		while (r > l) {
			int left = l;
			for (int u = r - 1; u > left; u--) {
				while (left < u && nums[left] + nums[u] <= nums[r]) {
					left++;
				}
				if (left < u) {
					res += u - left;
				}
			}
			r--;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 2, 3, 4 };
		System.out.println(triangleNumber(nums));
	}

}