package com.caleb.alorithm.leetcode;

/**
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * @author：hanzhigang
 * @Date : 2021/5/11 12:14 AM
 */
public class NumIslands200 {

    boolean[][] f;

    public int numIslands(char[][] grid) {
        int len1 = grid.length;
        int len2 = grid[0].length;
        int count = 0;
        f = new boolean[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (grid[i][j] == '1' && !f[i][j]) {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1' && !f[i][j]) {
            f[i][j] = true;
            dfs(i - 1, j, grid);
            dfs(i + 1, j, grid);
            dfs(i, j - 1, grid);
            dfs(i, j + 1, grid);
        }
    }

    public static void main(String[] args) {
        NumIslands200 numIslands200 = new NumIslands200();
        System.out.println(numIslands200.numIslands(
                new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

}
