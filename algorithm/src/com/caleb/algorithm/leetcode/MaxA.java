package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-30 09:04:11
 * 
 *       四键键盘
 * 
 *       假设你有一个特殊的键盘包含下面的按键：
 * 
 *       Key 1: (A)：在屏幕上打印一个 'A'。
 * 
 *       Key 2: (Ctrl-A)：选中整个屏幕。
 * 
 *       Key 3: (Ctrl-C)：复制选中区域到缓冲区。
 * 
 *       Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
 * 
 *       现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A'呢？
 */
public class MaxA {

	/**
	 * 动态规划
	 * 
	 * 子问题要独立
	 * 
	 * @param n
	 * @return
	 */
	public static int maxA(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 1; i < n + 1; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int j = 1; j <= i - 3; j++) {
				dp[i] = Math.max(dp[i], dp[i - j - 2] * (j + 1));
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(maxA(3));
	}

}