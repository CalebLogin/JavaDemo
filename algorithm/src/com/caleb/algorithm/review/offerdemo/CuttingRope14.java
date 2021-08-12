package com.caleb.algorithm.review.offerdemo;

/**
 * @author:Caleb
 * @Date :2021-08-04 16:35:04
 */
public class CuttingRope14 {

	public int cuttingRope(int n) {
		if (n <= 3) {
			return n - 1;
		}
		if (n % 3 == 1) {
			int count = n / 3;
			count--;
			return (int) Math.pow(3, count) * 4;
		}
		if (n % 3 == 2) {
			int count = n / 3;
			return (int) Math.pow(3, count) * 2;
		} else {
			int count = n / 3;
			return (int) Math.pow(3, count);
		}
	}

	public int cuttingRope1(int n) {
		if (n <= 3) {
			return n - 1;
		}
		int a = n / 3;
		int b = n % 3;
		long res = 1;
		while (a > 1) {
			res = (res * 3) % 1000000007;
			a--;
		}
		if (b == 1) {
			return (int)((res * 4) % 1000000007);
		} else if (b == 0) {
			return (int)((res * 3) % 1000000007);
		}
		return (int)((res * 6) % 1000000007);
	}

}