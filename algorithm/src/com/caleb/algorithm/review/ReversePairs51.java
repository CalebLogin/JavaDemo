package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-08-08 15:43:58
 */
public class ReversePairs51 {

	/**
	 * 暴力方法 超时
	 * 
	 * @param nums
	 * @return
	 */
	public int reversePairs(int[] nums) {
		int res = 0;
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] > nums[i]) {
					res++;
				}
			}
		}
		return res;
	}

	/**
	 * 二分法
	 * @param nums
	 * @return
	 */
	public int reversePairs1(int[] nums) {
		int n = nums.length;
		return reversePairsHelper(nums, 0, n - 1);
	}

	private int reversePairsHelper(int[] nums, int i, int j) {
		if (i < j) {
			int mid = i + (j - i) / 2;
			int res = reversePairsHelper(nums, i, mid) + reversePairsHelper(nums, mid + 1, j);
			int m = i, k = mid + 1;
			int[] temp = new int[j - i + 1];
			int pos = 0;
			while (pos < j - i + 1 && m <= mid && k <= j) {
				if (nums[k] < nums[m]) {
					temp[pos++] = nums[k++];
					res += (mid - m + 1);
				} else {
					temp[pos++] = nums[m++];
				}
			}
			while (m <= mid) {
				temp[pos++] = nums[m++];
			}
			while (k <= j) {
				temp[pos++] = nums[k++];
			}
			for (k = i, pos = 0; k <= j; k++, pos++) {
				nums[k] = temp[pos];
			}
			return res;
		}
		return 0;
	}

}