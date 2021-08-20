package com.caleb.main;

import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-08-18 19:34:55
 */
public class Main14 {

	public static void dinnerFood() {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int m = sc.nextInt();
		int[] xs = new int[m];
		for (int i = 0; i < m; ++i) {
			xs[i] = sc.nextInt();
		}
		sc.close();
		long[] dp = new long[x + 1];
		dp[xs[0]] = 1;
		dp[0] = 1;
		for (int i = 1; i < m; i++) {
			int price = xs[i-1];
			for (int j = x; j >= price; j--) {
				dp[j] = dp[j - price] + dp[j];
			}
		}
		System.out.println(dp[x]);
	}
	public static void main(String[] args) {
		dinnerFood();
	}

}