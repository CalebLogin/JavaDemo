package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-07 16:41:17
 * 
 *       数字1的个数
 * 
 *       给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 
 */
public class CountDigitOne233 {

	public int countDigitOne(int n) {
		int low = 0;
		int high = n;
		// 返回值
		int countNum = 0;
		// 处于第几位
		int pos = 1;
		int cur = 0;
		while (high != 0 || cur != 0) {
			cur = high % 10;
			high = high / 10;
			if (cur == 0) {
				countNum += high * pos;
			} else if (cur == 1) {
				countNum += low + (high) * pos + 1;
			} else {
				countNum += (high + 1) * pos;
			}
			low = cur * pos + low;
			pos *= 10;
		}
		return countNum;
	}

}