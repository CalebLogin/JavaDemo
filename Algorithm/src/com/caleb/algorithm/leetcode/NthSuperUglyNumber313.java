package com.caleb.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-08-10 09:12:50
 * 
 *       超级丑数
 * 
 *       超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 
 *       给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 
 *       题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * 
 */
public class NthSuperUglyNumber313 {

	public int nthSuperUglyNumber(int n, int[] primes) {
		int m = primes.length;
		int[] numPos = new int[m];
		int[] dp = new int[n];
		dp[0] = 1;
		Arrays.fill(numPos, 0);
		for (int i = 1; i < n; i++) {
			int minNum = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				if (dp[numPos[j]] * primes[j] < minNum) {
					minNum = dp[numPos[j]] * primes[j];
				}
			}
			for (int j = 0; j < m; j++) {
				if (dp[numPos[j]] * primes[j] == minNum) {
					numPos[j]++;
				}
			}
			dp[i] = minNum;
		}
		return dp[n - 1];
	}

	public int nthSuperUglyNumber1(int n, int[] primes) {
		Set<Long> seen = new HashSet<Long>();
		PriorityQueue<Long> heap = new PriorityQueue<Long>();
		seen.add(1L);
		heap.offer(1L);
		int ugly = 0;
		for (int i = 0; i < n; i++) {
			long curr = heap.poll();
			ugly = (int) curr;
			for (int prime : primes) {
				long next = curr * prime;
				if (seen.add(next)) {
					heap.offer(next);
				}
			}
		}
		return ugly;
	}

	public static void main(String[] args) {
		NthSuperUglyNumber313 n = new NthSuperUglyNumber313();
		System.out.println(n.nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 }));
	}

}