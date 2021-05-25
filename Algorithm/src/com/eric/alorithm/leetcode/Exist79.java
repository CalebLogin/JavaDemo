package com.eric.alorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * @author：hanzhigang
 * @Date : 2021/4/13 8:52 PM
 */
public class Exist79 {

    boolean[][] f;
    int row,col;

    public boolean exist(char[][] board, String word) {

        row = board.length;
        col = board[0].length;
        List<Integer> list = new ArrayList<>();
        f = new boolean[row][col];
        // 找到word首字母在board中出现的位置
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    list.add(i * col + j);
                }
            }
        }
        if(list.size() == 0){
            return false;
        }
        for (Integer i : list) {
            System.out.println(i);
            if (helper(board, word, 0, i / col, i % col)){
                return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int index, int i, int j) {
        boolean top, down, left, right;
        if (index == word.length()-1 && word.charAt(index) == board[i][j]) {
            return true;
        }
        if (i >= 0 && i < row && j >= 0 && j < col) {
            if (board[i][j] == word.charAt(index)) {
                f[i][j] = true;
                top = ((i - 1 >= 0) && !f[i - 1][j]) && helper(board, word, index + 1, i - 1, j);
                down = ((i + 1 < row) && !f[i + 1][j]) && helper(board, word, index + 1, i + 1, j);
                left = ((j - 1 >= 0) && !f[i][j - 1]) && helper(board, word, index + 1, i, j - 1);
                right = ((j + 1 < col) && !f[i][j + 1]) && helper(board, word, index + 1, i, j + 1);
                f[i][j] = false;
                return top || down || left || right || f[i][j];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Exist79 exist79 = new Exist79();
        System.out.println(exist79.exist(board, "ABCCED"));
    }
}
