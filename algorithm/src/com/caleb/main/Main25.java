package com.caleb.main;

import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-06 19:33:59
 */
public class Main25 {

	public void taoyan() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		for (int i = 0; i < n; i++) {
			String num = sc.next();
			if (isV(num)) {
				res++;
			}
		}
		sc.close();
		System.out.println(res);
	}

	public boolean isV(String s) {
		int l = s.length();
		int[] nums = new int[l];
		long ln = Long.parseLong(s);
		int index = 0;
		while (ln > 0) {
			nums[index++] = (int) ln % 10;
			ln /= 10;
		}
		int right = l - 1;
		while (right >= 1) {
			int currN = nums[right];
			for (int j = 0; j <= right; j++) {
				nums[j] = nums[j] - currN;
				if (nums[j] < 0) {
					return false;
				}
			}
			while (right >= 1 && nums[right] == 0) {
				right--;
			}
		}
		return nums[0] == 0;
	}

	public static void main(String[] args) {
		Main25 m = new Main25();
		m.taoyan();
	}

}