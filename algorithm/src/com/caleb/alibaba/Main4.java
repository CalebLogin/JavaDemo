package com.caleb.alibaba;

import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-08 09:14:07
 */
public class Main4 {

	public static void main4() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			long n = sc.nextLong();
			long m = sc.nextLong();
			long total = (1 + n * m) * (n * m) / 2;
			long subV = Math.abs(total - ((1 + (n - 1) * m + 1) * n));
			long subH = Math.abs(total - ((1 + m) * m));
			long vI = 1;
			long hI = 1;
			for (long i = m / 2; i < m; i++) {
				long subVt = Math.abs(total - ((i + 1) * (1 + (n - 1) * m + 1) * n / 2) + (i - 1) * n * i / 2);
				if (subVt <= subV) {
					vI = i;
					subV = subVt;
				} else {
					break;
				}
			}
			for (long i = n / 2; i < n; i++) {
				long subHt = Math.abs(total - ((1 + (i * m)) * (i * m)));
				if (subHt <= subH) {
					hI = i;
					subH = subHt;
				} else {
					break;
				}
			}
			if (subV < subH) {
				System.out.println("V " + (vI + 1));
			} else {
				System.out.println("H " + (hI + 1));
			}
		}
		sc.close();
	}

	public static void main(String[] args) {
		main4();
	}

}