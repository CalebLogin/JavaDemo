package com.caleb.algorithm.review.offerdemo;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-08-04 20:07:12
 */
public class MinNumber45 {

	public static String minNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
			System.out.println(strs[i]);
		}
		Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
		StringBuilder res = new StringBuilder();
		for (String s : strs)
			res.append(s);
		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println(minNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));
	}

}