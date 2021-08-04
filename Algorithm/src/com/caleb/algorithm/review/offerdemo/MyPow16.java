package com.caleb.algorithm.review.offerdemo;

/**
 * @author:Caleb
 * @Date :2021-08-04 17:26:54
 */
public class MyPow16 {

	/**
	 * 快速幂
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		double res = 1.0;
		long b = n;
		if (b < 0) {
			x = 1 / x;
			b = -b;
		}
		while (b > 0) {
			if ((b & 1) != 0) {
				res *= x;
			}
			x *= x;
			b >>= 1;
		}
		return res;
	}

}