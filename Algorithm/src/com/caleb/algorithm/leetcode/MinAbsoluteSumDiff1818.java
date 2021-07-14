package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-07-14 09:18:15
 * 
 *       绝对差值和
 * 
 *       给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * 
 *       数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的
 *       总和（下标从 0 开始）。
 * 
 *       你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * 
 *       在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * 
 *       |x| 定义为：如果 x >= 0 ，值为 x ，或者 如果 x <= 0 ，值为 -x
 * 
 */
public class MinAbsoluteSumDiff1818 {

	/**
	 * 暴力求解
	 */
	public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		int[] diff1 = new int[nums1.length];
		int[] diff2 = new int[nums2.length];
		int res = 0;
		int MOD = 1000000007;
		for (int i = 0; i < nums1.length; i++) {
			diff1[i] = Math.abs(nums1[i] - nums2[i]);
		}
		Arrays.sort(nums1);
		// 对数组2的中的每个值，寻找离它最近的
		for (int i = 0; i < nums1.length; i++) {
			int l = 0, r = nums1.length - 1;
			boolean flag = false;
			while (l <= r) {
				int mid = l + (r - l) / 2;
				if (nums1[mid] == nums2[i]) {
					diff2[i] = 0;
					flag = true;
					break;
				} else if (nums1[mid] < nums2[i]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
			if (!flag) {
				if (r < 0) {
					diff2[i] = Math.abs(nums1[l] - nums2[i]);
				} else if (l >= nums1.length) {
					diff2[i] = Math.abs(nums1[r] - nums2[i]);
				} else {
					diff2[i] = Math.min(Math.abs(nums1[l] - nums2[i]), Math.abs(nums1[r] - nums2[i]));
				}
			}
		}
		int maxIndex = 0;
		int maxVal = diff1[0] - diff2[0];
		for (int i = 0; i < nums1.length; i++) {
			int diffV = diff1[i] - diff2[i];
			if (maxVal < diffV) {
				maxVal = diffV;
				maxIndex = i;
			}
		}
		diff1[maxIndex] = diff2[maxIndex];
		for(Integer i : diff1){
			res = (res + i) % MOD;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,7,5};
		int[] nums2 = {2,3,5};
		MinAbsoluteSumDiff1818 m = new MinAbsoluteSumDiff1818();
		System.out.println(m.minAbsoluteSumDiff(nums1, nums2));
	}

}