package com.caleb.hulu;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author:Caleb
 * @Date :2021-08-26 20:14:30
 */
public class Main3 {

	public int throughMaze(int yourSteps, int devilSteps, String[] maze) {

		int[] posS = new int[2];
		int[] posD = new int[2];
		int[][] pos = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		boolean[][] devil = new boolean[maze.length][maze[0].length()];
		char[][] mazes = new char[maze.length][maze[0].length()];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length(); j++) {
				mazes[i][j] = maze[i].charAt(j);
				if (mazes[i][j] == 's') {
					posS[0] = i;
					posS[1] = j;
				}
				if (mazes[i][j] == 'd') {
					posD[0] = i;
					posD[1] = j;
					devil[i][j] = true;
				}
				if (mazes[i][j] == '1' || mazes[i][j] == '2') {
					devil[i][j] = true;
				}
			}
		}
		Queue<int[]> q = new ArrayDeque<>();
		if (posS[0] == posD[0] && posS[1] == posD[1]) {
			return -1;
		}
		q.add(new int[] { posS[0], posS[1], posD[0], posD[1] });
		while (q.isEmpty()) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

				}
			}
		}
		return 0;
	}

}