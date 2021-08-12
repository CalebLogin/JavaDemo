package com.caleb.algorithm.review.offerdemo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author:Caleb
 * @Date :2021-08-05 19:17:59
 */
public class NthUglyNumber264 {

	/**
	 * 动态规划+三指针
	 * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		int a = 0, b = 0, c = 0;
		for (int i = 1; i < n; i++) {
			int m = dp[a] * 2, k = dp[b] * 3, l = dp[c] * 5;
			dp[i] = Math.min(Math.min(m, k), l);
			if (m == dp[i]) {
				a++;
			}
			if (k == dp[i]) {
				b++;
			}
			if (l == dp[i]) {
				l++;
			}
		}
		return dp[n - 1];
	}

	/**
	 * 小根堆
	 * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumber1(int n) {
		if (n == 1) {
			return 1;
		}
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}

		});
		priorityQueue.offer(new int[] { 2, 2 });
		priorityQueue.offer(new int[] { 3, 3 });
		priorityQueue.offer(new int[] { 5, 5 });
		int[] pp = new int[2];
		for (int i = 1; i <= n; i++) {
			pp = priorityQueue.poll();
			priorityQueue.offer(new int[] { pp[0] * 2, 2 });
			if (pp[1] >= 3) {
				priorityQueue.offer(new int[] { pp[0] * 3, 3 });
				if (pp[1] >= 5) {
					priorityQueue.offer(new int[] { pp[0] * 5, 5 });
				}
			}
		}
		return pp[0];

	}

}