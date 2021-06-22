package com.caleb.algorithm.leetcode;

/**
 * 跳跃游戏II 给定一个非负整数数组，你最初位于数组的第一个位置。 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 假设你总是可以到达数组的最后一个位置。
 * 
 * @author:Caleb
 * @Date :2021-06-22 14:01:28
 */
public class Jump45 {

	/**
	 * 动态规划
	 * 
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		int start = 0;

		for (int i = 1; i < nums.length; i++) {
			for(int j = start;j<i;j++){
				if(nums[j] + j >= i){
					start = j;
					dp[i] = dp[j] + 1;
					break;
				}
			}
		}
		return dp[nums.length - 1];
	}

	/**
	 * 贪心算法1
	 * 
	 * @param nums
	 * @return
	 */
	public int jump1(int[] nums) {
		int position = nums.length - 1;
		int step = 0;
		while (position > 0) {
			for (int i = 0; i < position; i++) {
				if (nums[i] + i >= position) {
					position = i;
					step++;
					break;
				}
			}
		}
		return step;
	}

	/**
	 * 贪心算法2
	 * 
	 * @param nums
	 * @return
	 */
	public int jump2(int[] nums) {
		int steps = 0;
		int len = nums.length;
		int end = 0;
		int maxPosition = 0;
		for (int i = 0; i < len - 1; i++) {
			maxPosition = Math.max(maxPosition, i+nums[i]); // 总是跳到最远的距离，局部最优
			if(i == end){
				steps++;
				end = maxPosition;
			}
		}
		return steps;
	}

	public static void main(String[] args) {
		Jump45 j = new Jump45();
		System.out.println(j.jump(new int[] { 2, 3, 0, 1, 4 }));
	}

}