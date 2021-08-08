package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-08 14:48:29
 * 
 *       第 N 个泰波那契数
 * 
 *       泰波那契序列 Tn 定义如下： 
 * 
 *       T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 
 *       给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * 
 */
public class Tribonacci1137 {

	public static int tribonacci(int n) {
		int a = 0, b = 1, c = 1;
		for (int i = 1; i <= n; i++) {
			int temp = a + b + c;
			a = b;
			b = c;
			c = temp;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(tribonacci(25));
	}

}