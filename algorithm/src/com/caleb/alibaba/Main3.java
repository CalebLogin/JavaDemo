package com.caleb.alibaba;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-08-20 19:17:20
 */
public class Main3 {

	public static void p() {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		int[] sts = new int[5];
		Set<Integer> visited = new HashSet<>();
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = sc.nextLine();
		}
		sc.close();
		StringBuilder s = new StringBuilder();
		for (String str : strs) {
			String[] st = str.split(" ");
			int a = Integer.parseInt(st[0]);
			int b = Integer.parseInt(st[1]);
			int c = Integer.parseInt(st[2]);
			if (b == 1) {
				if (sts[c-1] < k && !visited.contains(a)) {
					sts[c-1]++;
					visited.add(a);
				}
			} else {
				sts[c-1]--;
			}
			s.append(helper(sts)+"\n");
		}
		System.out.print(s.toString());

	}
	public static String helper(int[] sts){
		StringBuffer s = new StringBuffer();
		for(Integer i : sts){
			s.append(i+" ");
		}
		return s.toString().trim();
	}
	public static void main(String[] args) {
		p();
	}

}