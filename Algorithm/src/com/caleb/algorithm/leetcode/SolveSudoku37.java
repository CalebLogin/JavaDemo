package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-07-02 22:03:47
 * 
 *       解数独
 * 
 *       编写一个程序，通过填充空格来解决数独问题。数独的解法需 遵循如下规则：
 *       数字 1-9 在每一行只能出现一次。数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的  3x3 宫内只能出现一次。
 *       （请参考示例图）数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 
 */
public class SolveSudoku37 {

	/**
	 * 判断行是否出现了这些数
	 * 判断列是否出现了这些数
	 * 判断子矩阵是否出现了这些数
	 * 将需要求解的位置记录下来
	 * 判断是否已经得到了真正的解
	 */
	boolean[][] lines = new boolean[9][9];
	boolean[][] columns = new boolean[9][9];
	boolean[][][] subBoards = new boolean[3][3][9];
	List<int[]> spaces = new ArrayList<>();
	boolean valid = false;

	/**
	 * 基本思路：3x3的块内，一行，一列，三行，三列
	 * 
	 * @param board
	 */
	public void solveSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					spaces.add(new int[] { i, j });
				} else {
					lines[i][board[i][j] - '1'] = true;
					columns[j][board[i][j] - '1'] = true;
					subBoards[i / 3][j / 3][board[i][j] - '1'] = true;
				}
			}
		}
		dfs(board, 0);
	}

	/**
	 * 
	 * @param board
	 * @param k
	 */
	private void dfs(char[][] board, int k) {
		if (k == spaces.size()) {
			valid = true;
			return;
		}
		int[] space = spaces.get(k);
		int row = space[0];
		int col = space[1];
		for (int i = 0; i < 9 && !valid; i++) {
			if (!lines[row][i] && !columns[col][i] && !subBoards[row / 3][col / 3][i]) {
				lines[row][i] = columns[col][i] = subBoards[row / 3][col / 3][i] = true;
				board[row][col] = (char) (i + '0' + 1);
				dfs(board, k + 1);
				lines[row][i] = columns[col][i] = subBoards[row / 3][col / 3][i] = false;
			}
		}
	}

}