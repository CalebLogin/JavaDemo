package com.caleb.tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-05 21:07:02
 */
public class Main3 {
	static Map<String, Integer> memo = new HashMap<>();
	static int[] V;

	public static void main3() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String S = sc.nextLine();
		sc.close();
		V = new int[n];
		for (int i = 0; i < n; i++) {
			V[i] = Integer.parseInt(S.charAt(i) + "");
		}
		for (int i = 0; i < n; i++) {
			memo.put(i + "" + i, 1);
		}
		int l = 0;
		while (l < n) {
			int r = l + 1;
			while (r < n && V[r] == V[l]) {
				memo.put(l + "" + r, memo.get(l + "" + (r - 1)) * 2 + 1);
			}
			l = r;
		}
		int maxV = 0;
		for (int i = 0; i < n; i++) {
			maxV = Math.max(dp(0, n - 1, i), maxV);
		}

	}

	public static int dp(int i, int j, int k) {
		if (i == k - 1 || j == k - 1) {
			return 1;
		}
		if (i > k - 1 || j < k + 1) {
			return 0;
		}
		int left = 0;
		int right = 0;
		if (i == k - 1) {
			left = 1;
		} else if (i > k - 1) {
			left = 0;
		} else {
			if (memo.containsKey(i + "" + (k - 1))) {
				left = memo.get(i + "" + (k - 1));
			} else {
				for (int m = i; m <= k - 1; m++) {
					left = Math.max(left, dp(i, k - 1, m));
				}
				memo.put(i + "" + (k - 1), left);
			}
		}
		if (j == k - 1) {
			right = 1;
		} else if (j > k - 1) {
			right = 0;
		} else {
			if (memo.containsKey((k + 1) + "" + j)) {
				right = memo.get((k + 1) + "" + j);
			} else {
				for (int m = k + 1; m <= j; m++) {
					right = Math.max(left, dp(i, j, m));
				}
				memo.put((k + 1) + "" + j, right);

			}
		}
		if (i <= k - 1 && j >= k + 1) {
			int m = k - 1;
			for (; m >= i; m--) {

			}
		}

		return left + right;
	}

	public static void main(String[] args) {
		main3();
	}

}