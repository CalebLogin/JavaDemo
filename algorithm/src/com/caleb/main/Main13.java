package com.caleb.main;

import java.util.Scanner;

public class Main13 {

	public static void chooseFood() {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		String[] foods = new String[n];
		for (int i = 0; i < n; i++) {
			foods[i] = sc.nextLine();
		}
		sc.close();
		int[] prices = new int[n];
		int[] counts = new int[n];
		int[] favorites = new int[n];
		for (int i = 0; i < n; i++) {
			String[] strs = foods[i].split(" ");
			prices[i] = Integer.parseInt(strs[0]);
			counts[i] = Integer.parseInt(strs[1]);
			favorites[i] = Integer.parseInt(strs[2]);
		}
		int[][] dp = new int[n + 1][x + 1];
		for (int i = 1; i <= n; i++) {
			int pri = prices[i-1];
			int count = counts[i-1];
			int f = favorites[i-1];
			for (int j = 1; j <= x; j++) {
				if (j > pri) {
					for (int c = 1; c <= count && c * pri <= j; c++) {
						dp[i][j] = Math.max(dp[i - 1][x], dp[i - 1][j - c * pri] + c * f);
					}
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][x]);
	}

	public static void main(String[] args) {
		chooseFood();
	}

}
