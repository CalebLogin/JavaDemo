package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * 下一个排列 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 必须 原地 修改，只允许使用额外常数空间。
 * 
 * @author:Caleb
 * @Date :2021-06-21 12:34:51
 */
public class NextPermutation31 {

	public void nextPermutation(int[] nums) {
		int len = nums.length;
		int i = len - 2;
		// 判断是否是递减序列，从后向前找，如果不是，记录第一个破坏规则的数字的下标
		for (; i >= 0 && nums[i] >= nums[i + 1]; i--) {

		}
		// 如果存在破坏规则的数字
		if (i >= 0) {
			int j = len - 1;
			// 找到大于nums[i]的最小数
			for (; j >= i + 1; j--) {
				if (nums[j] > nums[i]) {
					break;
				}
			}
			// 切换位置
			swap(nums, i, j);
		}
		// 对递减序列或者第一个破坏规则的数字下标后的递减序列变成递增序列
		reverse(nums, i + 1, len - 1);
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] res = new int[] { 1, 3, 2 };
		NextPermutation31 nextPermutation31 = new NextPermutation31();
		nextPermutation31.nextPermutation(res);
		for (Integer i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}