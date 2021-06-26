package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-06-26 23:19:12
 * 
 *       Pow(x,n)
 * 
 *       实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
 */
public class MyPow50_ {

	/**
	 * 实现logn的时间复杂度
	 * 
	 * 快速幂 + 递归
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		if (x == 1) {
			return 1;
		}
		if (x == 0) {
			return 0;
		}
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				n = Integer.MAX_VALUE;
				return myPow(1 / (x * x), n);
			}
			n = -n;
			return myPow(1 / x, n);
		}
		if (n == 0) {
			return 1;
		}
		double res = myPow(x, n / 2);
		return n % 2 == 0 ? res * res : res * res * x;
	}

	public static void main(String[] args) {
		MyPow50_ myPow50 = new MyPow50_();
		System.out.println(myPow50.myPow(2,9));
	}

}