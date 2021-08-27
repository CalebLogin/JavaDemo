package com.caleb.hulu;

import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-08-26 19:34:49
 */
public class Main2 {

	int N;
	int res = 0;
	long A;
	long B;

	public void calModNNum() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = sc.nextLong();
		B = sc.nextLong();
		sc.close();
		int numCountA = calSum(A);
		int numCountB = calSum(B) + 1;
		for (int i = numCountA; i <= numCountB; i++) {
			int count = 100 / N;
			for (int j = 1; j <= count; j++) {
				helper(0, N * j, i-1, 0);
			}
		}
		System.out.println(res);
	}

	public void helper(int start, int count, int last, long num) {
		if (start > last) {
			return;
		}
		if ((start == last && (count >= 0 && count <= 9)) ||(start < last && count <= 0)) {
			if (start == last && (num * 10 + count >= A && num * 10 + count <= B)) {
				res++;
			} else {
				long t = (long) (num * Math.pow(10, (last - start + 1)));
				if (t >= A && t <= B) {
					res++;
				}
			}
			return;
		}
		for (int i = 1; i < count && i <= 9; i++) {
			helper(start + 1, count - i, last, num * 10 + i);
		}
	}

	public int calSum(long x) {
		int sum = 0;
		while (x != 0) {
			sum++;
			x /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		Main2 m = new Main2();
		m.calModNNum();
	}

}