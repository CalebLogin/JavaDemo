package com.caleb.main;

import java.math.BigInteger;
import java.util.Scanner;

public class Main11 {
	public static void twoArraySum() {
		BigInteger res = BigInteger.valueOf(0);
		int index = 0;
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		sc.close();
		String[] scc = s.split(" ");
		int[] nums = new int[count];
		BigInteger left = BigInteger.valueOf(0);
		BigInteger right = BigInteger.valueOf(0);
		for (int i = 0; i < count; i++) {
			nums[i] = Integer.parseInt(scc[i]);
			right = right.add(BigInteger.valueOf(nums[i]));
		}
		for (int i = 0; i < count; i++) {
			left = left.add(BigInteger.valueOf(nums[i]));
			right = right.subtract(BigInteger.valueOf(nums[i]));
			if (left.multiply(right).compareTo(res) == 1) {
				index = i + 1;
				res = left.multiply(right);
			}
		}
		System.out.println(index);
	}

	public static void main(String[] args) {
		twoArraySum();
	}
}
