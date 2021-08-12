package com.caleb.algorithm.review.offerdemo;

/**
 * @author:Caleb
 * @Date :2021-08-04 19:35:09
 */
public class SingleNumbers56I {

	public int[] singleNumbers(int[] nums) {
		int afterCal = 0;
		for (int n : nums) {
			afterCal ^= n;
		}
		int a = 0, b = 0, bitPos = 1;
		while ((afterCal & bitPos) != 1) {
			bitPos <<= 1;
		}
		for (int n : nums) {
			if ((bitPos & n) == 1) {
				a ^= n;
			} else {
				b ^= n;
			}
		}
		return new int[] { a, b };
	}

}