package com.caleb.algorithm.leetcode;

/**
 * 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * @author: Caleb
 * @Date  : 2021-06-11 14:25:30
 * ============================
 */
import java.util.Arrays;
public class LengthOfLIS300 {


	/**
	 * 动态规划
	 * dp[i] 表示以i结尾的最长递增子序列是多少
	 */
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		int max = 0;
		Arrays.fill(dp, 1);
		for (int i = 0; i < len; i++) {
			for (int j = i-1; j >= 0; j--) {
				if(nums[i] > nums[j]){
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
			max = Math.max(dp[i], max);
		}
		return max;

	}

	/**
	 * 贪心 + 二分查找
	 * 贪心的思想是让递增的间隔尽可能的小
	 * 设计一个新的队列用来存储
	 */
	public int lengthOfLIS1(int[] nums){
		int len = nums.length;
		int[] tails = new int[len];
		
		return 0;
	}


	public static void main(String[] args) {
		LengthOfLIS300 l = new LengthOfLIS300();
		System.out.println(l.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
	}

}
