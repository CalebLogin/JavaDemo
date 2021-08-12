package com.caleb.algorithm.review.offerdemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:Caleb
 * @Date :2021-08-04 15:45:26
 */
public class MovingCount13 {

	public int movingCount(int m, int n, int k) {
		int[] pos = new int[] { -1, 1 };
		int res = 0;
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		visited[0][0] = true;
		res++;
		while (!queue.isEmpty()) {
			int[] num = queue.poll();
			for (int i = 0; i < 2; i++) {
				int num1 = num[0];
				int num2 = num[1] + pos[i];
				// 没有访问过
				if (num1 >= 0 && num1 < m && num2 >= 0 && num2 < n) {
					if (!visited[num1][num2] && countSum(num1, num2) <= k) {
						res++;
						visited[num1][num2] = true;
						queue.offer(new int[] { num1, num2 });
					}
				}
				num1 = num[0] + pos[i];
				num2 = num[1];
				if (num1 >= 0 && num1 < m && num2 >= 0 && num2 < n) {
					if (!visited[num1][num2] && countSum(num1, num2) <= k) {
						res++;
						visited[num1][num2] = true;
						queue.offer(new int[] { num1, num2 });
					}
				}
			}
		}
		return res;
	}

	private int countSum(int num1, int num2) {
		int res = 0;
		while (num1 > 0) {
			res += num1 % 10;
			num1 /= 10;
		}
		while (num2 > 0) {
			res += num2 % 10;
			num2 /= 10;
		}
		return res;
	}

}