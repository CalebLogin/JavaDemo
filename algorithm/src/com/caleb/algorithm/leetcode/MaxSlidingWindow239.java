package com.caleb.algorithm.leetcode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。 你只可以看到在滑动窗口内的
 * k 个数字。滑动窗口每次只向右移动一位。 返回滑动窗口中的最大值
 * 
 * @author:Caleb
 * @Date :2021-06-18 20:03:01
 */
public class MaxSlidingWindow239 {

	/**
	 * 暴力解法
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k == 1) {
			return nums;
		}
		int len = nums.length;
		int maxIndex = findMaxVIndex(nums, 0, k - 1);
		int[] resMax = new int[len - k + 1];
		resMax[0] = nums[maxIndex];
		for (int i = k; i < len; i++) {
			if (i - k + 1 <= maxIndex) {
				if (nums[i] >= nums[maxIndex]) {
					maxIndex = i;
				}
			} else {
				maxIndex = findMaxVIndex(nums, i - k + 1, i);

			}
			resMax[i - k + 1] = nums[maxIndex];
		}
		return resMax;
	}

	private int findMaxVIndex(int[] nums, int start, int end) {
		int maxIndex = start;
		for (int i = start; i <= end; i++) {
			if (nums[i] > nums[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	/**
	 * 大根堆
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow1(int[] nums, int k) {
		int len = nums.length;
		int[] resMax = new int[len - k + 1];
		PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
			}

		});
		for (int i = 0; i < k; i++) {
			p.offer(new int[] { nums[i], i });
		}
		resMax[0] = p.peek()[0];
		for (int i = k; i < len; i++) {
			p.offer(new int[] { nums[i], i });
			while (p.peek()[1] <= i - k) {
				p.poll();
			}
			resMax[i - k + 1] = p.peek()[0];
		}
		return resMax;
	}

	/**
	 * 单调双端队列
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow2(int[] nums, int k) {
		Deque<Integer> d = new LinkedList<>();
		int len = nums.length;
		// 存放最大值的下标
		int[] resMax = new int[len - k + 1];
		for(int i = 0;i < k; i++){
			while(!d.isEmpty() && nums[d.peekLast()] < nums[i]){
				d.pollLast();
			}
			d.addLast(i);
		}
		resMax[0] = nums[d.peekFirst()];
		for(int i = k;i<len;i++){
			while(!d.isEmpty() && d.peekFirst() <= i- k){
				d.pollFirst();
			}
			while(!d.isEmpty() && nums[d.peekLast()] < nums[i]){
				d.pollLast();
			}
			d.add(i);
			resMax[i -k + 1] = nums[d.peekFirst()];
		}
		return resMax;
	}

	public static void main(String[] args) {
		MaxSlidingWindow239 maxSlidingWindow239 = new MaxSlidingWindow239();
		int[] res = maxSlidingWindow239.maxSlidingWindow2(new int[] { 7, 2, 4 }, 2);
		for (Integer i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}