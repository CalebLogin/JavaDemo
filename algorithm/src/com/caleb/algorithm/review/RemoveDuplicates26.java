package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-08-15 16:48:55
 */
public class RemoveDuplicates26 {

	public int removeDuplicates(int[] nums) {
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[index]) {
				nums[++index] = nums[i];
			}
		}
		return index + 1;
	}

}