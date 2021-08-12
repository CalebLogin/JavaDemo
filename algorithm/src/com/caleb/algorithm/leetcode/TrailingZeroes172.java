package com.caleb.algorithm.leetcode;

/**
 * 阶乘后的零 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 
 * @author：hanzhigang
 * @Date : 2021/5/7 11:39 PM
 */
public class TrailingZeroes172 {

	/**
	 * 暴力求解
	 * 
	 * @param n
	 * @return
	 */
	public int trailingZeroes(int n) {
		int resCount = 0;
		for (int i = 5; i <= n; i += 5) {
			if (i % 5 == 0) {
				int num = i;
				while (num % 5 == 0) {
					resCount++;
					num /= 5;
				}
			}
		}
		return resCount;
	}

	/**
	 * 二分查找
	 * 
	 * @param n
	 * @return
	 */
	public int trailingZeroes1(int n) {
		int count = 0;
		while (n > 0) {
			count += n / 5;
			n = n / 5;
		}
		return count;
	}

	public int trailingZeroes2(int n) {
		return n / 5 + n / 25 + n / 125 + n / 625 + n / 3125 + n / 15625 + n / 78125 + n / 390625 + n / 1953125
				+ n / 9765625 + n / 48828125 + n / 244140625 + n / 1220703125;
	}

	public static void main(String[] args) {
		TrailingZeroes172 t = new TrailingZeroes172();
		System.out.println(t.trailingZeroes(50));
	}

}
