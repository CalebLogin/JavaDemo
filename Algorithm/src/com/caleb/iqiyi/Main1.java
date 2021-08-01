package com.caleb.iqiyi;

import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-08-01 16:16:33
 */
public class Main1 {

	public static void window() {
		double maxP = Double.MIN_VALUE;
		Scanner sc = new Scanner(System.in);

		String line = sc.next();
		sc.close();
		String[] strs = line.split(",");
		int k = Integer.parseInt(strs[strs.length - 1].split(":")[1]);
		strs[strs.length - 1] = strs[strs.length - 1].split(":")[0];
		int[] nums = new int[strs.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}
		if (k > strs.length) {
			System.out.println("0.00%");
			return;
		}
		int l = 0, r = k - 1;
		double total = 0.0;
		double verTotal = 0.00000;
		for (int i = l; i <= r; i++) {
			total += nums[i];
		}
		verTotal = total / (double) k;
		r++;
		while (r < nums.length) {
			total += nums[r++];
			total -= nums[l++];
			double currVer = total / k;
			double change = (currVer - verTotal) / verTotal;
			verTotal = currVer;
			if (change > maxP) {
				maxP = change;
			}
		}
		System.out.println(String.format("%.2f", maxP * 100) + "%");
	}

	public static void main(String[] args) {
		window();
	}

}