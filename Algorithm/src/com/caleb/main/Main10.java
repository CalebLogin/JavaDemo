package com.caleb.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-08-12 19:21:40
 */
public class Main10 {

	public static void redGreenBlue() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		Map<Integer, Double>[] dp = new Map[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = new HashMap<>();
		}
		dp[0].put(0, 1.0);
		double[] pp = new double[3];
		pp[0] = 20.0;
		pp[1] = 12.0;
		pp[2] = 6.0;
		for (int i = 1; i < n; i++) {
			Map<Integer, Double> di = dp[i];
			for (int j = 1; j <= 20; j++) {
				if (i - j >= 0) {
					if (j > 6 && i - j % 3 == 2) {
						continue;
					}
					if (j > 12 && i - j % 3 == 1) {
						continue;
					}
					Map<Integer, Double> temp = dp[i - j];
					for (Map.Entry<Integer, Double> entry : temp.entrySet()) {
						int k = entry.getKey();
						Double v = entry.getValue();
						di.put(k + 1, di.getOrDefault(k + 1, 0.0) + v / pp[(i - j) % 3]);
					}
				}

			}
		}
		double res = 0.0;
		Map<Integer, Double> resM = dp[n];
		for (int j = 1; j <= 20; j++) {
			if (n - j >= 0) {
				if (j > 6 && n - j % 3 == 2) {
					continue;
				}
				if (j > 12 && n - j % 3 == 1) {
					continue;
				}
				Map<Integer, Double> temp = dp[n - j];
				for (Map.Entry<Integer, Double> entry : temp.entrySet()) {
					int k = entry.getKey();
					Double v = entry.getValue();
					resM.put(k + 1,
							resM.getOrDefault(k + 1, 0.0) + ((int) pp[(n - j) % 3] - j + 1) * v / pp[(n - j) % 3]);
				}
			}
		}
		for (Map.Entry<Integer, Double> entry : resM.entrySet()) {
			res += entry.getKey() * entry.getValue();
		}
		System.out.println(String.format("%.2f", res));
	}

	public static void main(String[] args) {
		redGreenBlue();
	}

}