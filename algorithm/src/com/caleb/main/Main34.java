package com.caleb.main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-09-22 15:07:52
 */
public class Main34 {

	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int[][] matrix = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			count = 0;
			Set<Integer> colors = new HashSet<>();
			dfs(0, 0, colors, matrix, n, m);
			System.out.println(count);
		}
	}

	public static void dfs(int x, int y, Set<Integer> colors, int[][] matrix, int n, int m) {
		if (x == n - 1 && y == m - 1) {
			if (!colors.contains(matrix[x][y])) {
				count++;
			}
			return;
		}
		if (x >= n || y >= m) {
			return;
		}
		if (colors.contains(matrix[x][y])) {
			return;
		} else {
			colors.add(matrix[x][y]);
			dfs(x + 1, y, colors, matrix, n, m);
			dfs(x, y + 1, colors, matrix, n, m);
			colors.remove(matrix[x][y]);
		}
	}

}