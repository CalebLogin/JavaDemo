package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-10 09:41:51
 * 
 *       等差数列划分
 * 
 *       例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。 给你一个整数数组 nums ，返回数组
 *       nums 中所有为等差数组的 子数组 个数。
 * 
 *       子数组 是数组中的一个连续序列。
 * 
 */
public class NumberOfArithmeticSlices413 {

	/**
	 * 差分
	 * 
	 * @param nums
	 * @return
	 */
	public int numberOfArithmeticSlices(int[] nums) {
		int res = 0;
		int n = nums.length;
		if (n < 3) {
			return 0;
		}
		for (int left = 0; left <= n - 3; left++) {
			int q = nums[left] - nums[left + 1];
			int right = left + 2;
			for (; right < n && nums[right - 1] - nums[right] == q; right++)
				;
			if (right - left >= 3) {
				res += (right - left + 2);
			}
		}
		return res;

	}

	public static void main(String[] args) {
		NumberOfArithmeticSlices413 n = new NumberOfArithmeticSlices413();
		System.out.println(n.numberOfArithmeticSlices(new int[] { 1, 2, 3, 8, 9, 10 }));
	}

}