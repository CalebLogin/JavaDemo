package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-08-11 17:23:12
 * 
 *       等差数列划分II - 子序列
 * 
 *       给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * 
 *       如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * 
 *       例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。 再例如，[1, 1, 2,
 *       5, 7] 不是等差序列。 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * 
 *       例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。 题目数据保证答案是一个 32-bit 整数。
 */
public class NumberOfArithmeticSlices446_ {

	int res = 0;
	int n = 0;

	/**
	 * 超时
	 * 
	 * @param nums
	 * @return
	 */
	public int numberOfArithmeticSlices(int[] nums) {
		n = nums.length;
		long[] numl = new long[n];
		for (int i = 0; i < n; i++) {
			numl[i] = nums[i];
		}
		for (int i = 0; i < n; i++) {
			for (int k = 1; k < n - i; k++) {
				int right = i + k;
				if (right < n) {
					long d = numl[right] - numl[i];
					numberOfArithmeticSlicesHelper(numl, right, 1, d);
				}
			}
		}
		return res;
	}

	/**
	 * 
	 * @param nums
	 * @param start
	 * @param count 当前符合等差序列的个数
	 */
	private void numberOfArithmeticSlicesHelper(long[] nums, int start, int count, long d) {
		if (count >= 2) {
			res++;
		}
		for (int i = start + 1; i < n; i++) {
			long tempD = nums[i] - nums[start];
			if (tempD == d) {
				numberOfArithmeticSlicesHelper(nums, i, count + 1, d);
			}
		}

	}

	public int numberOfArithmeticSlices1(int[] nums) {
		int n = nums.length;
		int res = 0;
		Map<Long, Integer>[] f = new Map[n];
		for (int i = 0; i < n; i++) {
			f[i] = new HashMap<>();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				long d = 1L * nums[i] - nums[j];
				int cnt = f[j].getOrDefault(d, 0);
				res += cnt;
				f[i].put(d, f[i].getOrDefault(d, 0) + 1 + cnt);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		NumberOfArithmeticSlices446_ numberOfArithmeticSlices446 = new NumberOfArithmeticSlices446_();
		System.out
				.println(numberOfArithmeticSlices446.numberOfArithmeticSlices(new int[] { 0, 2000000000, -294967296 }));
	}

}