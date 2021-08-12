package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-06-16 11:42:28
 */
public class FindMin153 {

	/**
	 * 二分查找
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] > nums[r]) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return nums[l];
	}

	public static void main(String[] args) {
		FindMin153 f = new FindMin153();
		System.out.println(f.findMin(new int[] { 3,1,2 }));
	}

}