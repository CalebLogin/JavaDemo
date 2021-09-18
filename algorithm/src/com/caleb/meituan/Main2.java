package com.caleb.meituan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-09-18 16:10:29
 */
public class Main2 {

	static Set<String> set = new HashSet<>();
	static int[] allPas = new int[5];
	static Set<Integer> visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] matrix = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			matrix[start][end] = 1;
			matrix[end][start] = 1;
		}
		sc.close();
		for (int i = 1; i <= n; i++) {
			visited = new HashSet<>();
			visited.add(i);
			dfs(matrix, i, 5, n);
		}	
		System.out.println(set.size());
	}

	public static void dfs(int[][] matrix, int start, int left, int n) {
		for (int i = 1; i <= n; i++) {
			if (!visited.contains(i) && matrix[start][i] == 1) {
				allPas[left - 1] = i;
				visited.add(i);
				if (left > 1) {
					dfs(matrix, i, left - 1, n);
				} else {
					int[] temp = new int[5];
					for(int j = 0;j<5;j++){
						temp[j] = allPas[j];
					}
					Arrays.sort(temp);
					String str = temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4];
					set.add(str);
				}
				visited.remove(i);
			}
		}
	}

}