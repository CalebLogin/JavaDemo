package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-07-24 16:28:05
 * 
 *       N皇后
 * 
 * 
 *       n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 *       给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 
 *       每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 */
public class SolveNQueens51 {

	char[][] cheers;
	List<List<String>> res;

	/**
	 * 深度优先遍历
	 * 
	 * @param n
	 * @return
	 */
	public List<List<String>> solveNQueens(int n) {
		res = new ArrayList<>();
		cheers = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(cheers[i], '.');
		}
		dfs(cheers, 0, n);
		return res;
	}

	private void dfs(char[][] cheers, int start, int n) {
		if (start == n) {
			List<String> tempRes = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				tempRes.add(new String(cheers[i]));
			}
			res.add(tempRes);
			return;
		}

		for (int i = 0; i < n; i++) {
			cheers[start][i] = 'Q';
			if (isAvail(cheers, start, i)) {
				dfs(cheers, start + 1, n);
			}
			cheers[start][i] = '.';
		}
	}

	/**
	 * 判断当前位置是否合法
	 * 
	 * @param cheers
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean isAvail(char[][] cheers, int i, int j) {
		int upJ = j;
		int lowJ = j;
		for (int x = 1; x <= i; x++) {
			if (cheers[i - x][j] == 'Q') {
				return false;
			}
			upJ = j - x;
			lowJ = j + x;
			if (upJ >= 0) {
				if (cheers[i - x][upJ] == 'Q') {
					return false;
				}

			}
			if (lowJ < cheers.length) {
				if (cheers[i - x][lowJ] == 'Q') {
					return false;
				}
			}

		}
		return true;
	}

	public static void main(String[] args) {
		SolveNQueens51 s = new SolveNQueens51();
		List<List<String>> res = s.solveNQueens(1);
		System.out.println(res.toString());
	}

}