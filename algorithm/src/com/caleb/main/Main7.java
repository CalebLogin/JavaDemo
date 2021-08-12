package com.caleb.main;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-07-07 21:35:49
 * 
 *       中国象棋
 * 
 */
public class Main7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		// 起点和终点的位置
		int[] T = new int[2];
		int[] H = new int[2];
		// 最小步数
		int minCount = 0;
		// 定义是否被访问过
		boolean[][] visited = new boolean[row][col];
		// 定义马走的步幅
		int[] pos1 = { -1, 1 };
		int[] pos2 = { -2, 2 };
		char[][] chess = new char[row][col];
		for (int i = 0; i < row; i++) {
			String oneLine = sc.nextLine();
			for (int j = 0; j < col; j++) {
				chess[i][j] = oneLine.charAt(j);
				if (chess[i][j] == 'H') {
					H[0] = i;
					H[1] = j;
					visited[i][j] = true;
				}
				if (chess[i][j] == 'T') {
					T[0] = i;
					T[1] = j;
					visited[i][j] = true;
				}
				if (chess[i][j] == '#') {
					visited[i][j] = true;
				}
			}
		}
		sc.close();
		Queue<int[]> q = new LinkedList<>();
		q.add(H);
		// BFS
		while (!q.isEmpty()) {
			minCount++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] temp = q.poll();
				for (int m = 0; m < 2; m++) {
					for (int n = 0; n < 2; n++) {
						int x = temp[0] + pos1[m];
						int y = temp[1] + pos2[n];
						if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]
								&& chess[x][((y + temp[1]) / 2)] != '#') {
							if (x == T[0] && y == T[1]) {
								System.out.println(minCount);
								return;
							}
							q.add(new int[] { x, y });
							visited[x][y] = true;
						}
						x = temp[0] + pos2[m];
						y = temp[1] + pos1[n];
						if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]
								&& chess[((x + temp[0]) / 2)][y] != '#') {
							if (x == T[0] && y == T[1]) {
								System.out.println(minCount);
								return;
							}
							q.add(new int[] { x, y });
							visited[x][y] = true;
						}

					}
				}
			}
		}
		System.out.println(-1);
	}

}
