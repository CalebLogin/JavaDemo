package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 直线上最多的点数 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y
 * 平面上的一个点。求最多有多少个点在同一条直线上。 points = [[1,1],[2,2],[3,3]]
 * 
 * @author:Caleb
 * @Date :2021-06-24 09:39:31
 */
public class MaxPoints149 {

	public int maxPoints(int[][] points) {
		int len = points.length;
		if (len <= 2) {
			return len;
		}
		int maxSum = 0;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				int count = 2;
				for (int k = j + 1; k < len; k++) {
					long dxk = (points[k][0] - points[j][0]) * (points[j][1] - points[i][1]);
					long dyk = (points[k][1] - points[j][1]) * (points[j][0] - points[i][0]);
					if (dxk == dyk) {
						count++;
					}
				}
				maxSum = Math.max(maxSum, count);
				if (maxSum > len / 2) {
					return maxSum;
				}
			}
		}
		return maxSum;
	}

	public int maxPoints1(int[][] points) {
		int len = points.length;
		if (len <= 2) {
			return len;
		}
		int maxSum = 0;
		for (int i = 0; i < len - 1; i++) {
			Map<String, Integer> map = new HashMap<>();
			int max = 0;
			for (int j = i + 1; j < len; j++) {
				int dx = points[j][0] - points[i][0], dy = points[j][1] - points[i][1];
				int k = gcd(dx, dy); // 将斜率约干净
				String key = (dy / k) + "_" + (dx / k);
				map.put(key, map.getOrDefault(key, 0) + 1);
				max = Math.max(max, map.get(key));
			}
			maxSum = Math.max(maxSum, max + 1);
		}
		return maxSum;
	}

	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

}