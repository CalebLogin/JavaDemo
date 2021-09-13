package com.caleb.bilibili;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-09-13 19:29:01
 */
public class Main1 {

	static Set<String> visited = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> input = new ArrayList<>();
		while (sc.hasNext()) {
			String str = sc.nextLine().replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
			input.add(str);
		}
		int m = input.size();
		int n = input.get(0).length();
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			String[] strs = input.get(i).split("");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(strs[j]);
			}
		}
		int maxVa = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited.contains((i * n + j) + "") && matrix[i][j] == 1) {
					int currV = maxV(matrix, i, j);
					maxVa = Math.max(maxVa, currV);
				}
			}
		}
		System.out.println(maxVa);
	}

	public static int maxV(int[][] matrix, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
			return 0;
		}
		if (!visited.contains((i * matrix[0].length + j) + "") && matrix[i][j] == 1) {
			visited.add((i * matrix[0].length + j) + "");
			return maxV(matrix, i + 1, j) + maxV(matrix, i - 1, j) 
						+ maxV(matrix, i, j - 1) + maxV(matrix, i, j + 1) + 1;
		}
		return 0;
	}

}