package com.caleb.main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-16 14:39:18
 */
public class Main29 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] nums = new int[26];
		Arrays.fill(nums, -1);
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			if (nums[index] == -1) {
				nums[index] = i;
			} else {
				nums[index] = -2;
			}
		}
		Integer minIndex = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (nums[i] != -1 && nums[i] != -2) {
				minIndex = Math.min(minIndex, nums[i]);
			}
		}
		if(minIndex.equals(Integer.MAX_VALUE)){
			System.out.println(-1);
			return;
		}
		System.out.println(str.charAt(minIndex));
	}

}