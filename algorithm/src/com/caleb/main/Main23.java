package com.caleb.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main23 {

	List<String> list = new ArrayList<>();
	int res = 0;

	public void huiwen() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		char[] charArray = s.toCharArray();
		dfs(charArray, 0, charArray.length);
		System.out.println(res);
	}

	public void dfs(char[] charArray, int i, int n) {
		if (i >= n) {
			for (String str : list) {
				if (!isValid(str)) {
					return;
				}
			}
			res++;
			return;
		}
		for (int k = 1; k <= n - i; k++) {
			list.add(new String(charArray, i, k));
			dfs(charArray, i + k, n);
			list.remove(list.size() - 1);
		}
	}

	public boolean isValid(String s) {
		char[] charArray = s.toCharArray();
		int l = 0, r = charArray.length - 1;
		if (l == r) {
			return true;
		}
		for (int i = 1; i <= r / 2; i++) {
			if (new String(charArray, l, i).equals(new String(charArray, r - i + 1, i))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Main23 m = new Main23();
		m.huiwen();
	}

}