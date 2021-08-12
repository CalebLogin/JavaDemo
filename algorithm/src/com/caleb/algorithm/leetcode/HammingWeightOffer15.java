package com.caleb.algorithm.leetcode;

/**
 * 二进制中1的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * @author:Caleb
 * @Date  :2021-06-23 08:39:13
 */
public class HammingWeightOffer15{

	public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

	public int hammingWeight1(int n) {
        int count = 0;
		while(n != 0){
			count++;
			// 可以去掉最右边的1，每次去掉一个1
			n = n & (n-1);
		}
		return count;
    }

	public static void main(String[] args) {
		HammingWeightOffer15 h = new HammingWeightOffer15();
		System.out.println(h.hammingWeight(9));
	}

}