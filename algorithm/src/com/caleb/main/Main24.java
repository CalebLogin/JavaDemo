package com.caleb.main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-06 16:51:25
 */
public class Main24 {
	int minV = Integer.MAX_VALUE;

	public void minFee() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int s = sc.nextInt();
		int d = sc.nextInt();
		int K = sc.nextInt();
		String lines = sc.next();
		sc.close();
		lines = lines.replaceAll("\\[", "");
		lines = lines.replaceAll("\\]", "");
		String[] liness = lines.split(",");
		int[][] adjacentM = new int[m][m];
		for (int i = 0; i < liness.length; i += 3) {
			adjacentM[Integer.parseInt(liness[i])][Integer.parseInt(liness[i + 1])] = Integer.parseInt(liness[i + 2]);
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { s, 0, 0 });
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] stop = q.poll();
				int n = stop[0];
				int k = stop[1];
				int f = stop[2];
				if (k > K) {
					continue;
				}
				for (int j = 0; j < m; j++) {
					if (adjacentM[n][j] != 0) {
						if (j == d) {
							minV = Math.min(minV, f + adjacentM[n][j]);
						}else{
							q.offer(new int[] { j, k + 1, f + adjacentM[n][j] });
						}
					}
				}
			}
		}
		System.out.println(minV);
	}

	public static void main(String[] args) {
		Main24 m = new Main24();
		m.minFee();
	}

}