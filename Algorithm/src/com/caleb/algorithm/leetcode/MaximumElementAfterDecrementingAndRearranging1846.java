package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-07-15 08:50:52
 * 
 *       减少和重新排列数组后的最大元素
 * 
 *       给你一个正整数数组 arr 。请你对 arr 执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
 * 
 *       arr 中 第一个 元素必须为 1 。
 * 
 *       任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0
 *       开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
 * 
 *       你可以执行以下 2 种操作任意次：
 * 
 *       减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
 * 
 *       重新排列 arr 中的元素，你可以以任意顺序重新排列。
 * 
 *       请你返回执行以上操作后，在满足前文所述的条件下，arr 中可能的 最大值 。
 * 
 */
public class MaximumElementAfterDecrementingAndRearranging1846 {

	/**
	 * 动态规划
	 * 
	 * @param arr
	 * @return
	 */
	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

		Arrays.sort(arr);
		arr[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] + 1 <= arr[i] ? arr[i - 1] + 1 : arr[i];
		}
		return arr[arr.length - 1];
	}

	public static void main(String[] args) {
		MaximumElementAfterDecrementingAndRearranging1846 m = new MaximumElementAfterDecrementingAndRearranging1846();
		System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[] { 1, 2, 3, 4, 5 }));
	}

}