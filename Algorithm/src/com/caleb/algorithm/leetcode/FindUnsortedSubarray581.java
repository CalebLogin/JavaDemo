package com.caleb.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author:Caleb
 * @Date :2021-08-03 22:16:03
 * 
 *       最短无序连续子数组
 * 
 *       给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 
 *       请你找出符合题意的 最短 子数组，并输出它的长度。
 * 
 *       输入：nums = [2,6,4,8,10,9,15] 输出：5 解释：你只需要对 [6, 4, 8, 10, 9]
 *       进行升序排序，那么整个表都会变为升序排序。
 * 
 */
public class FindUnsortedSubarray581 {

	/**
	 * 大跟堆小根堆
	 * 
	 * @param nums
	 * @return
	 */
	public static int findUnsortedSubarray(int[] nums) {
		// 定义一个小根堆
		PriorityQueue<int[]> priorityQueue1 = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] != o2[1]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}

		});
		// 定义一个大跟堆
		PriorityQueue<int[]> priorityQueue2 = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] != o2[1]) {
					return o2[1] - o1[1];
				} else {
					return o2[0] - o1[0];
				}
			}
		});
		for (int i = 0; i < nums.length; i++) {
			priorityQueue1.add(new int[] { i, nums[i] });
			priorityQueue2.add(new int[] { i, nums[i] });
		}
		int i = 0;
		for (; i < nums.length; i++) {
			int[] temp = priorityQueue1.poll();
			if (temp[0] != i) {
				break;
			}
		}
		int j = nums.length - 1;
		for (; j >= 0; j--) {
			int[] temp = priorityQueue2.poll();
			if (temp[0] != j) {
				break;
			}
		}
		System.out.println(i + " " + j);
		if (i >= j) {
			return 0;
		} else {
			return j - i + 1;
		}
	}

	/**
	 * 排序
	 * 
	 * @param nums
	 * @return
	 */
	public int findUnsortedSubarray1(int[] nums) {
		if (isSorted(nums)) {
			return 0;
		}
		int[] numsSorted = new int[nums.length];
		System.arraycopy(nums, 0, numsSorted, 0, nums.length);
		Arrays.sort(numsSorted);
		int left = 0;
		while (nums[left] == numsSorted[left]) {
			left++;
		}
		int right = nums.length - 1;
		while (nums[right] == numsSorted[right]) {
			right--;
		}
		return right - left + 1;
	}

	public boolean isSorted(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				return false;
			}
		}
		return true;
	}

	// 双指针 + 线性扫描
	public static int findUnsortedSubarray2(int[] nums) {
		int n = nums.length;
		int i = 0, j = n - 1;
		int MIN = -10005, MAX = 10005;
		while (i < j && nums[i] <= nums[i + 1]) {
			i++;
		}
		while (i < j && nums[j] >= nums[j - 1]) {
			j--;
		}
		int l = i, r = j;
		int min = nums[l];
		int max = nums[r];
		for (int u = l; u <= r; u++) {
			if (nums[u] < min) {
				while (i >= 0 && nums[u] < nums[i]) {
					i--;
				}
				min = i >= 0 ? nums[i] : MIN;
			}
			if (nums[u] > max) {
				while (j < n && nums[u] > nums[j]) {
					j++;
				}
				max = j < n ? nums[j] : MAX;
			}
		}
		return i == j ? 0 : (j - 1) - (i + 1) + 1;

	}

	public static void main(String[] args) {
		System.out.println(findUnsortedSubarray2(new int[] { 0, 1, 2, 3, 4, 5, 7, 6, 8, 9 }));
	}

}
