package com.caleb.main;

public class Main18 {
	public static int func(int i, int j) {
		if (i <= 0 || j <= 0) {
			return 1;
		}
		return 2 * func(i - 3, j / 2);
	}

	public static void main(String[] args) {
		System.out.println(func(15, 20));
		int a = 10;
		System.out.println(a++ + a--);
	}
}
