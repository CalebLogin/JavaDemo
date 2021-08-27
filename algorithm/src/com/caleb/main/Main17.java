package com.caleb.main;

import java.util.Scanner;

public class Main17 {
	int minTime = Integer.MAX_VALUE;
	int[][] liveTime;
	int[][] pos = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	boolean[][] visited;

	public void keepLive() {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		liveTime = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				liveTime[i][j] = sc.nextInt();
			}
		}
		sc.close();
		visited = new boolean[row][col];
		helper(0, 0, 0);
		if (minTime == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minTime);
		}
	}

	public void helper(int time, int i, int j) {
		if (i == liveTime.length - 1 && j == liveTime[0].length - 1) {
			if (liveTime[i][j] - time > 0) {
				minTime = Math.min(minTime, time);
			} else {
				return;
			}
		}
		for (int k = 0; k < 4; k++) {
			int ni = i + pos[k][0];
			int nj = j + pos[k][1];
			if (ni < 0 || ni >= liveTime.length || nj < 0 || nj >= liveTime[0].length) {
				continue;
			}
			if (!visited[ni][nj] && liveTime[ni][nj] - time > 0) {
				visited[ni][nj] = true;
				helper(time + 1, ni, nj);
				visited[ni][nj] = false;
			}
		}
	}

	public static void findMaxSubSeq() {
		int maxRes = Integer.MIN_VALUE;
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] matrix = new int[row + 1][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = matrix[i - 1][j] + sc.nextInt();
			}
		}
		sc.close();
		for (int i = 1; i <= row; i++) {
			for (int j = i; j <= row; j++) {
				int res = matrix[j][0] - matrix[i - 1][0];
				for (int m = 1; m < col; m++) {
					if (res < 0) {
						res = matrix[j][m] - matrix[i - 1][m];
					} else {
						res += (matrix[j][m] - matrix[i - 1][m]);
					}
					maxRes = Math.max(maxRes, res);
				}
			}
		}
		System.out.println(maxRes);
	}

	public static void main(String[] args) {
		// Main17 m = new Main17();
		// m.keepLive();
		findMaxSubSeq();
	}

}
