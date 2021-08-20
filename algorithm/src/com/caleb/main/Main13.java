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
		int[] dp = new int[x + 1];
		for (int i = 1; i <= n; i++) {
			int pri = prices[i - 1];
			int count = counts[i - 1];
			int f = favorites[i - 1];
			for (int j = x; j >= pri; j--) {
				int c = Math.min(j / pri, count);
				for (; c >= 0; c--) {
					dp[j] = Math.max(dp[j], dp[j - c * pri] + f * c);
				}
			}
		}
		System.out.println(dp[x]);
	}

	public static void main(String[] args) {
		chooseFood();
	}

}
