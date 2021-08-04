package com.caleb.algorithm.review.offerdemo;

/**
 * @author:Caleb
 * @Date :2021-08-04 15:19:37
 */
public class SingleNumber56II {

	/**
	 * 统计所有数字的各二进制出现的次数，并对3取余
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		int res = 0;
		int[] count = new int[32];
		for (int num : nums) {
			for (int i = 0; i < 32; i++) {
				count[i] += num & 1;
				num >>>= 1;
			}
		}
		for (int co : count) {
			co %= 3;
		}
		for (int i = 0; i < 32; i++) {
			res <<= 1;
			res |= count[31 - i];
		}
		return res;
	}

}