package com.caleb.jd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-11 19:41:01
 */
public class Main2 {

	public void main2() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[][] m1 = new int[n + 1][n + 1];
		int[][] m2 = new int[n + 1][n + 1];
		int[] v = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int c = sc.nextInt();
			for (int j = 0; j < c; j++) {
				int next = sc.nextInt();
				m1[i][next] = 1;
				m2[next][i] = 1;
			}
		}
		for (int i = 0; i < q; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(totalNum(m1, m2, v, x, y, n));
		}
		sc.close();
	}

	public int totalNum(int[][] m1, int[][] m2, int[] v, int x, int y, int n) {
		int[][] m;
		if (x == 0) {
			m = m2;
		} else {
			m = m1;
		}
		int finalCount = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(y);
		if (v[y] == x) {
			for (int i = 1; i <= n; i++) {
				finalCount += v[i];
			}
			return finalCount;
		} else {
			v[y] = x;
		}
		while (!q.isEmpty()) {
			int next = q.poll();
			for (int j = 1; j <= n; j++) {
				if (j == next) {
					continue;
				}
				if (m[next][j] != 0 && v[j] != x) {
					v[j] = x;
					q.add(j);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			finalCount += v[i];
		}
		return finalCount;
	}

	public static void main(String[] args) {
		Main2 m = new Main2();
		m.main2();
	}

}