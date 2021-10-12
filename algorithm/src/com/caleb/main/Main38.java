package com.caleb.main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-10-09 20:53:47
 */
public class Main38 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long res = -1;
		int n = sc.nextInt();
		long k = sc.nextLong();
		long d = sc.nextLong();
		long[][] love = new long[n][3];
		long[] ad = new long[n];
		long[] eat = new long[n];
		for (int i = 0; i < n; i++) {
			love[i][0] = sc.nextLong();
		}
		for (int i = 0; i < n; i++) {
			love[i][1] = sc.nextLong();
		}
		for (int i = 0; i < n; i++) {
			love[i][2] = sc.nextLong();
		}
		Arrays.sort(love,(a,b)->Long.compare(a[0], b[0]));
		for (int i = 0; i < n; i++) {
			long addp = love[i][1];
			double eatp = d * i / n;
			if(addp <= k && eatp <= love[i][2]){
				res = Math.max(res, love[i][0]);
			}
		}
		System.out.println(res);
	}

}