package com.caleb.algorithm.leetcode;

import java.util.Arrays;


/**
 * 摆动排序II 给你一个整数数组 nums， 将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 
 * @author:Caleb
 * @Date :2021-06-12 11:56:19
 */
public class WiggleSort324 {

	/**
	 * 难点：要把重复的分布在不同的地方 第一种方法，将数组排序，分成两个数组，然后反序
	 * 分析：对于重复数值达到数据长度一半时，会出现重复数值被分到一起的情况，利用倒序来避免这种情况
	 * 
	 * @param nums
	 */
	public void wiggleSort(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
		int[] temp = new int[len];
		System.arraycopy(nums, 0, temp, 0, len);
		for (int i = 0; i < len; i++) {
			nums[i] = i % 2 == 0 ? temp[len / 2 + len % 2 - i / 2] : temp[len - 1 - i / 2];
		}
	}

	/**
	 * 分析：只要重复数字出现在A的头部，B的尾部即可 只需要满足A和B长度相同（或相差1），且A中的元素小于等于B中的元素，且r出现在A的头部和B的尾部即可
	 * （0）快速排序查找中位数 （1）Three Partition way：按照数组的中位数，将数组中的数值分散到左右两个部分 （2）虚地址 ?
	 * 
	 * @param nums
	 */
	public void wiggleSort1(int[] nums) {
		int len = nums.length;
		if(len < 2){
			return;
		}
		int mid = partition(nums, len / 2 + len % 2, 0, len - 1);
		int left = 0, right = len - 1;
		threePartition(nums, mid, left, right);
		int[] temp = new int[len];
		for(int num:nums){
			System.out.print(num);
		}
		System.out.println();
		System.arraycopy(nums, 0, temp, 0, len);
		for (int i = 0; i < len; i++) {
			nums[i] = i % 2 == 0 ? temp[len / 2 + len % 2 - 1 - i / 2] : temp[len - 1 - i / 2];
		}
		for(int num:nums){
			System.out.print(num);
		}
		System.out.println();
	}

	private int partition(int[] nums, int k, int start, int end) {
		int key = nums[start];
		int left = start, right = end;
		while (left < right) {
			while (left < right && nums[right] >= key) {
				right--;
			}
			if (left < right) {
				swap(nums, left, right);
			}
			while (left < right && nums[left] <= key) {
				left++;
			}
			if (left < right) {
				swap(nums, left, right);
			}
		}
		if (left == k) {
			return nums[left];
		} else if (left < k) {
			return partition(nums, k, left + 1, end);
		} else {
			return partition(nums, k, start, left - 1);
		}
	}

	private void threePartition(int[] nums, int k, int L, int R) {
		int less = L - 1;
		int more = R + 1;
		while (L < more) {
			if (nums[L] < k) {
				swap(nums, L++, ++less);
			} else if (nums[L] > k) {
				swap(nums, --more, L);
			} else {
				L++;
			}
		}
	}

	private void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
	

	public static void main(String[] args) {
		WiggleSort324 wiggleSort324 = new WiggleSort324();
		wiggleSort324.wiggleSort1(new int[] {1,1,2,1,2,2,1});
	}
}
