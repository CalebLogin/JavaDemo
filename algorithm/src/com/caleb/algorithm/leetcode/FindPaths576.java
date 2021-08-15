package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-15 15:07:27
 * 
 *       出界的路径数
 * 
 *       给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn]
 *       。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * 
 *       给你五个整数 m、n、maxMove、startRow 以及 startColumn
 *       ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 */
public class FindPaths576 {

	int maxRes = 0;
	int INF = 1000000007;
	int[] pos = new int[] { -1, 1 };

	/**
	 * 深度优先遍历
	 * 
	 * 超时
	 * 
	 * 需加上记忆化搜索
	 * 
	 * @param m
	 * @param n
	 * @param maxMove
	 * @param startRow
	 * @param startColumn
	 * @return
	 */
	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		dfs(m, n, maxMove, startRow, startColumn, 0);
		return maxRes;
	}

	public void dfs(int m, int n, int maxMove, int startRow, int startColumn, int moveCount) {
		if (moveCount > maxMove) {
			return;
		}
		if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
			maxRes = (maxRes + 1) % INF;
			return;
		}
		for (int i = 0; i < 2; i++) {
			int nextRow = startRow;
			int nextColumn = startColumn + pos[i];
			dfs(m, n, maxMove, nextRow, nextColumn, moveCount + 1);
			nextRow = startRow + pos[i];
			nextColumn = startColumn;
			dfs(m, n, maxMove, nextRow, nextColumn, moveCount + 1);
		}
	}

	/**
	 * 动态规划
	 * 
	 * @param m
	 * @param n
	 * @param maxMove
	 * @param startRow
	 * @param startColumn
	 * @return
	 */
	public int findPaths1(int m, int n, int maxMove, int startRow, int startColumn) {
		int[][] dp = new int[m][n];
		int res = 0;
		dp[startRow][startColumn] = 1;
		for (int i = 0; i < maxMove; i++) {
			int[][] temp = new int[m][n];
			for (int k = 0; k < m; k++) {
				for (int j = 0; j < n; j++) {
					if (dp[k][j] > 0) {
						for (int p = 0; p < 2; p++) {
							int nextRow = k;
							int nextColumn = j + pos[p];
							if (nextColumn < 0 || nextColumn >= n) {
								res = (res + dp[k][j]) % INF;
							} else {
								temp[nextRow][nextColumn] = (temp[nextRow][nextColumn] + dp[k][j]) % INF;
							}
							nextRow = k + pos[p];
							nextColumn = j;
							if (nextRow < 0 || nextRow >= m) {
								res = (res + dp[k][j]) % INF;
							} else {
								temp[nextRow][nextColumn] = (temp[nextRow][nextColumn] + dp[k][j]) % INF;
							}
						}
					}
				}
			}
			dp = temp;
		}
		return res;
	}

	public static void main(String[] args) {
		FindPaths576 f = new FindPaths576();
		System.out.println(f.findPaths1(1, 3, 3, 0, 1));
	}

}