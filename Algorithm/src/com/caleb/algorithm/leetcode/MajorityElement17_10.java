package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-07-09 19:09:03
 * 
 *       主要元素
 * 
 *       数组中占比超过一半的元素称之为主要元素。 给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N)
 *       、空间复杂度为 O(1) 的解决方案。
 * 
 */
public class MajorityElement17_10 {

	public int majorityElement(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}
		int count = 1;
		int currNum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (currNum == nums[i]) {
				count++;
			} else {
				if (count >= 0) {
					count--;
				}
				if (count < 0) {
					count = 1;
					currNum = nums[i];
				}
			}
		}
		if (count >= 0) {
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == currNum) {
					sum++;
				}
			}
			if (sum > nums.length / 2) {
				return currNum;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		MajorityElement17_10 m = new MajorityElement17_10();
		System.out.println(m.majorityElement(new int[]{3,2}));
	}


}
