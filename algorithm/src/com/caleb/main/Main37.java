package com.caleb.main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-10-09 20:04:44
 */
public class Main37 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextLong();
		long x = sc.nextLong();
		long[] vas = new long[n];
		for (int i = 0; i < n; i++) {
			vas[i] = sc.nextLong();
		}
		Arrays.sort(vas);
		int left = 0;
		int ll = 0;
		int pre = -1;
		for (int i = 1; i < n; i++) {
			if(vas[i] - vas[i - 1] > x){
				left += 1;
				if (i - pre > 1) {
					ll += 1;
				}
				pre = i;
			}
		}
		int res = (int) (left + 1 - Math.min(ll, k));
		System.out.println(res);

	}

}