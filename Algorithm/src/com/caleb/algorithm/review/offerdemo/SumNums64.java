package com.caleb.algorithm.review.offerdemo;

/**
 * @author:Caleb
 * @Date :2021-08-06 16:49:41
 */
public class SumNums64 {

	public int sumNums(int n) {
		boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
		return n;
	}
}