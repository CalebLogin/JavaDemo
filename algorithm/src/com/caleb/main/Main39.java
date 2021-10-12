package com.caleb.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main39 {

	public static void main(String[] args) {
		Map<String, Integer> hasCount = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		long res = 0;
		String[] arrStr = sc.nextLine().replace("[", "").replace("]", "").split(" ");
		if (arrStr.length == 0) {
			System.out.println(res);
			return;
		}
		for (String str : arrStr) {
			hasCount.put(str, hasCount.getOrDefault(str, 0) + 1);
			if (hasCount.getOrDefault(str, 0) == 2) {
				res += Integer.parseInt(str);
			}
		}
		System.out.println(res);
	}

}