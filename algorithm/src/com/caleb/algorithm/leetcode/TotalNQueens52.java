package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:Caleb
 * @Date  :2021-07-24 17:15:09
 */
public class TotalNQueens52{


	char[][] cheers;
	List<List<String>> res;
	public int totalNQueens(int n) {
		res = new ArrayList<>();
		cheers = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(cheers[i], '.');
		}
		dfs(cheers, 0, n);
		return res.size();
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

}