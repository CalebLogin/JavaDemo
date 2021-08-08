package com.caleb.algorithm.review;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author:Caleb
 * @Date :2021-08-08 15:25:19
 */
public class MaxSlidingWindow59 {

	/**
	 * 单调队列
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 1) {
			return nums;
		}
		int n = nums.length;
		// 定义单调队列
		Deque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < k - 1; i++) {
			while (!q.isEmpty() && q.peekLast()[0] < nums[i]) {
				q.pollLast();
			}
			q.offerLast(new int[] { nums[i], i });
		}
		int[] res = new int[n - k + 1];
		for (int i = k - 1; i < n; i++) {
			while (!q.isEmpty() && q.peekLast()[0] < nums[i]) {
				q.pollLast();
			}
			q.offerLast(new int[] { nums[i], i });
			while (!q.isEmpty() && q.peekFirst()[1] < i - k + 1) {
				q.pollFirst();
			}
			res[i - k + 1] = q.peekFirst()[0];
		}
		return res;
	}

}
