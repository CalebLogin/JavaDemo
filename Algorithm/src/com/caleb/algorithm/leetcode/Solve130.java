package com.caleb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * @author：hanzhigang
 * @Date : 2021/4/19 9:11 PM
 */
public class Solve130 {

    int m, n;   // 字符数组的行数和列数

    /**
     * dfs
     *
     * @param board
     */
    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        //
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);   // 对第i行的第一列进行深度优先遍历
            dfs(board, i, n - 1);   // 对第i行对的最后一列进行深度优先遍历
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i); // 对第i列的第一行进行深度优先遍历
            dfs(board, m - 1, i);   // 对第i列的最后一行进行深度优先遍历
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
    }

    /**
     * bfs
     *
     * @param board
     */
    public void solve1(char[][] board) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();    // 存放边界为O的坐标
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[]{i, n - 1});
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
            }
            if (board[m - 1][i] == 'O') {
                queue.offer(new int[]{m - 1, i});
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0], y = tmp[1];
            board[x][y] = 'A';
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i], newY = y + dy[i];
                if (newX < 0 || newX >= m || newX < 0 || newY >= n || board[newX][newY] != 'O') {
                    continue;
                }
                queue.offer(new int[]{newX, newY});
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
