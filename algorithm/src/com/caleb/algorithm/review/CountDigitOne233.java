package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-08-13 20:03:23
 */
public class CountDigitOne233 {

	public int countDigitOne(int n) {
		int res = 0;
		int left = n;
		int right = 0;
		int pos = 1;
		while (left > 0) {
			int num = left % 10;
			left /= 10;
			if (num == 0) {
				res += left * pos;
			} else if (num == 1) {
				res += left * pos + right + 1;
			} else {
				res += (left + 1) * pos;
			}
			right = num * pos + right * 10;
			pos *= 10;
		}
		return res;

	}

}