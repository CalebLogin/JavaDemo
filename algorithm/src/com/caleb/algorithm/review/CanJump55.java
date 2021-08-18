package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-08-18 16:43:35
 */
public class CanJump55 {

	/**
	 * 维护一个最远可以到达的范围
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		int n = nums.length;
		int farPos = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (i > farPos) {
				return false;
			}
			farPos = Math.max(farPos, i + nums[i]);
		}
		return farPos >= n - 1;
	}

}