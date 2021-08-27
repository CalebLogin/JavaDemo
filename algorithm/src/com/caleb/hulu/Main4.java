package com.caleb.hulu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-08-26 20:36:27
 */
public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		float[][] repository = new float[num][2];
		float[][] gradient = new float[num][4];
		int res = 0;
		for (int i = 0; i < num; i++) {
			repository[i][0] = sc.nextFloat();
			repository[i][1] = sc.nextFloat();
		}
		sc.close();
		for (int i = 0; i < num; i++) {
			gradient[i][0] = repository[i][0];
			gradient[i][1] = repository[i][1];
			gradient[i][2] = Math.abs(1 - repository[i][1]) / (repository[i][0]);
			gradient[i][3] = Math.abs(repository[i][1] + 1) / (repository[i][0]);
		}
		Arrays.sort(gradient, (o1, o2) -> Float.compare(o1[0], o2[0]));
		int[] dp = new int[gradient.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			int max = 0;
			float grad1 = gradient[i][2];
			float grad2 = gradient[i][3];
			for (int j = 0; j < i; j++) {
				float gradd1 = gradient[j][2];
				float gradd2 = gradient[j][3];
				if (grad1 < gradd1 && grad2 < gradd2) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}

}