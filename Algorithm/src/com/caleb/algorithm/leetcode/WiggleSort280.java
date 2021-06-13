package com.caleb.algorithm.leetcode;

import java.util.Arrays;
/**
 * 摆动排序 给你一个无序的数组 nums, 将该数字 原地重排后使得 nums[0] <= nums[1] >= nums[2] <=
 * nums[3]...。 输入: nums = [3,5,2,1,6,4] 输出: 一个可能的解答是 [3,5,1,6,2,4]
 * 
 * @author:Caleb
 * @Date :2021-06-11 23:02:44
 */
public class WiggleSort280 {

	/**
	 * 
	 * @param nums
	 */
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length - 1; i += 2) {
			swap(nums, i, i + 1);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}

	public void wiggleSort1(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (i % 2 == 0) {
				if (nums[i] > nums[i + 1]) {
					swap(nums, i, i + 1);
				}
			} else {
				if (nums[i] < nums[i + 1]) {
					swap(nums, i, i + 1);
				}
			}
		}
	}

	public void wiggleSort2(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
				swap(nums, i, i + 1);
			}
		}
	}

	public static void main(String[] args) {
		WiggleSort280 wiggleSort280 = new WiggleSort280();
		wiggleSort280.wiggleSort2(new int[] { 3, 5, 2, 1, 6, 4 });
	}

}