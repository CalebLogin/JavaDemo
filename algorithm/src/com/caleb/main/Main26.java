package com.caleb.main;

import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-06 20:00:13
 */
public class Main26 {

	public static void beHappy() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] hV = new long[n];
		for (int i = 0; i < n; i++) {
			hV[i] = sc.nextLong();
		}
		sc.close();
		long[] dp = new long[n];
		int maxV = -1;
		for (int i = 0; i < n; i++) {
			dp[i] = Long.MIN_VALUE;
			for (int j = i; j >= 1; j--) {
				dp[j] = Math.max(dp[j - 1] + hV[i], dp[j]);
			}
			dp[0] = Math.max(dp[0], hV[i]);
		}
		for (int i = n - 1; i >= 0; i--) {
			if (dp[i] >= 0) {
				maxV = i;
				break;
			}
		}
		System.out.println(maxV + 1);
	}

	public static void main(String[] args) {
		beHappy();
	}

}