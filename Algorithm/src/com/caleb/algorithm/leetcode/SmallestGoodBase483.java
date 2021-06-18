package com.caleb.algorithm.leetcode;

/**
 * 最小好进制 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。 以字符串的形式给出 n,
 * 以字符串的形式返回 n 的最小好进制。
 * 
 * @author:Caleb
 * @Date :2021-06-18 08:58:32
 */
public class SmallestGoodBase483 {

	public String smallestGoodBase(String n) {
		Long targetNum = Long.parseLong(n);
		// 找到最大的进制数
		int mMax = (int) Math.floor(Math.log(targetNum) / Math.log(2));
		for (int m = mMax; m > 1; m--) {
			int k = (int) Math.pow(targetNum, 1.0 / m);
			long currNum = 1,mul = 1;
			for (int j = 0; j < m; j++) {
				mul *= k;
				currNum += mul;
			}
			if (currNum == targetNum) {
				return String.valueOf(k);
			}
		}
		return String.valueOf(targetNum - 1);
	}

	public static void main(String[] args) {
		SmallestGoodBase483 smallestGoodBase483 = new SmallestGoodBase483();
		System.out.println(smallestGoodBase483.smallestGoodBase("14919921443713777"));
	}

}