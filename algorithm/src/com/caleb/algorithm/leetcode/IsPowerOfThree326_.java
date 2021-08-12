package com.caleb.algorithm.leetcode;

/**
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方i
 * 如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * @author:Caleb
 * @Date  :2021-06-13 23:42:42
 */
public class IsPowerOfThree326_{

	public boolean isPowerOfThree(int n) {

		if(n < 1){
			return false;
		}
		while(n %3 == 0){
			n /= 3;
		}
		return n == 1;
    }

}