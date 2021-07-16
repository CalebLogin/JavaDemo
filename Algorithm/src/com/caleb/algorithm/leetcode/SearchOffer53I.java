package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-07-16 09:20:43
 */
public class SearchOffer53I {

	public int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target) {
				int left = 0, right = 0;
				for (int i = mid; i >= 0 && nums[i] == target; i--) {
					left++;
				}
				for (int j = mid + 1; j < nums.length && nums[j] == target; j++) {
					right++;
				}
				return left + right;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		SearchOffer53I s = new SearchOffer53I();
		int[] nums = {5,7,7,8,8,10};
		System.out.println(s.search(nums, 8));
	}

}