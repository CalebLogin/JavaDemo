package com.caleb.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-07-23 09:42:40
 * 
 *       检查是否区域内所有整数都被覆盖 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] =
 *       [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 * 
 *       如果闭区间 [left,
 *       right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 * 
 *       已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <=
 *       endi ，那么我们称整数x 被覆盖了。
 * 
 * 
 */
public class IsCovered1893 {

	public boolean isCovered(int[][] ranges, int left, int right) {
		int totalSum = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < ranges.length; i++) {
			int leftR = ranges[i][0];
			int rightR = ranges[i][1];
			if (!(right < leftR || left > rightR)) {
				leftR = Math.max(leftR, left);
				rightR = Math.min(rightR, right);
				totalSum += (leftR + rightR) * (rightR - leftR + 1) / 2;
				for (int k = leftR; k <= rightR; k++) {
					if (set.contains(k)) {
						totalSum -= k;
					}
					set.add(k);
				}
			}
		}
		return totalSum == (left + right) * (right - left + 1) / 2;
	}

	public boolean isCovered1(int[][] ranges, int left, int right) {
		int[] diff = new int[52];
		for (int i = 0; i < ranges.length; i++) {
			++diff[ranges[i][0]];
			--diff[ranges[i][1] + 1];
		}
		// 前缀和
		int curr = 0;
		for (int i = 1; i <= 50; ++i) {
			curr += diff[i];
			if (i >= left && i <= right && curr <= 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsCovered1893 isCovered1893 = new IsCovered1893();
		int[][] ranges = { { 1, 50 } };
		System.out.println(isCovered1893.isCovered(ranges, 1, 50));
	}

}
