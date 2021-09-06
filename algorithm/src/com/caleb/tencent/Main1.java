package com.caleb.tencent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-05 20:29:00
 */
public class Main1 {

	public static void maxCount() {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<>();
		int n = sc.nextInt();
		int[] nums1 = new int[n];
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			int time = 0;
			if (map.containsKey(num)) {
				time = map.get(num);
			} else {
				time = getFactor(num);
				map.put(num, time);
			}
			nums1[i] = time;
		}
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			int time = 0;
			if (map.containsKey(num)) {
				time = map.get(num);
			} else {
				time = getFactor(num);
				map.put(num, time);
			}
			nums[i] = time;
		}
		sc.close();
		Arrays.sort(nums1);
		Arrays.sort(nums);
		int res = 0;
		if (nums1[nums.length - 1] < nums[0]) {
			res = 0;
		} else {
			int left1 = 0;
			int left = 0;
			while (left < nums.length && left1 < nums1.length) {
				while (left1 < nums1.length && nums1[left1] <= nums[left]) {
					left1++;
				}
				left1++;
				left++;
				res++;
			}
		}
		System.out.println(res);

	}

	public static int getFactor(int n) {
		int count = 0;
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				if ((n / i) * (n / i) == 1) {
					count++;
				} else {
					count += 2;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		maxCount();
	}

}