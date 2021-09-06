package com.caleb.main;

import java.util.Arrays;
import java.util.Comparator;

public class A {

	public Float[] getKAverage(Float[] raw_data, int K) {
		int n = raw_data.length;
		Float[] res = new Float[n - K + 1];
		int l = 0, r = K - 1;
		float tmpV = 0;
		for (int i = 0; i < K - 1; i++) {
			tmpV += raw_data[i];
		}
		while (r < n) {
			tmpV += raw_data[r++];
			res[l] = tmpV / K;
			tmpV -= raw_data[l++];
		}
		return res;
	}

	public String[] scoresort(String[] names, String[] scores) {
		int n = names.length;
		int[][] scoresF = new int[n][2];
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			String sc = scores[i];
			String[] scc = sc.split(",");
			int s = 0;
			for (String str : scc) {
				s += Integer.parseInt(str);
			}
			scoresF[i][0] = i;
			scoresF[i][1] = s;
		}
		Arrays.sort(scoresF, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}
		});
		for (int i = 0; i < n; i++) {
			res[i] = names[scoresF[i][0]];
		}
		return res;

	}

	public static void main(String[] args) {
		Float[] i = new Float[] { 22.1f, 22.3f, 22.4f, 22.7f, 22.0f, 24.0f, 25.0f, 27.0f, 28.0f, 27.0f, 29.0f, 27.0f,
				26.0f, 25.0f, 24.0f, 24.0f, 23.0f, 21.0f, 20.0f, 22.0f };
		Float[] res = new A().getKAverage(i, 5);
		for (Float a : res) {
			System.out.println(a);
		}
		String[] res1 = new A().scoresort(new String[]{"w","l","ll"}, new String[]{"89,92,95,88,91","92,96,81,90,92","89,91,91,78,79"});
		for(String str : res1){
			System.out.println(str);
		}
	}
}
