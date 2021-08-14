package com.caleb.main;

import java.util.Scanner;

public class Main12 {
	public void totalCount() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int len = 0;
		int num = n;
		int res = 0;
		while (num > 0) {
			len++;
			num /= 10;
		}
		if (len == 1) {
			System.out.println(n);
			return;
		}
		int preLen = 0;
		if (len % 2 == 1) {
			preLen = len - 2;
		} else {
			preLen = len - 1;
		}
		if (preLen >= 1) {
			for (int i = 1; i <= preLen; i += 2) {
				int mid = (1 + i) / 2;
				int preMid = (mid - 1);
				int lastMid = (i - mid);
				for (int m = mid; m <= 9; m++) {
					res += calcuCount(m, preMid) + calcuCount(m, lastMid);
				}
			}
		}
		if (len % 2 == 0) {
			System.out.println(res);
			return;
		} else {
			int mid = (len + 1) / 2;
			num = n;
			int pos = 0;
			int midNum = 0;
			while (mid != pos) {
				midNum = num % 10;
				num /= 10;
				pos++;
			}
		}
	}

	public int calcuCount(int num, int pos) {
		int res = 0;
		if (pos == 0) {
			return 0;
		}
		int c = num - pos;
		for (int i = 1; i <= c; i++) {
			res += (1 + i) * (i) / 2;
		}
		return res;
	}

}
