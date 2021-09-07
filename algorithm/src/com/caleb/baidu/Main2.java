package com.caleb.baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-07 20:21:22
 */
public class Main2 {

	public void main2() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			if (map.containsKey(n)) {
				System.out.println(map.get(n));
			} else {
				int times = isV(n);
				map.put(n, times);
				System.out.println(times);
			}
		}
		sc.close();
	}

	public int isV(int n) {
		int count = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if ((n % i) == 0 && gcd(i, n / i) == 1) {
				count++;
			}
		}
		return count;
	}

	public int gcd(int x, int y) {
		return y == 0 ? x : gcd(y, x % y);
	}

	public static void main(String[] args) {
		Main2 m = new Main2();
		m.main2();
	}

}