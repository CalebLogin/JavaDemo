package com.caleb.offerdemo;

/**
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径
 *
 * @author：hanzhigang
 * @Date : 2021/3/3 10:39 AM
 */
public class OfferDemo12 {
    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        char[] words = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, char[] words, int i, int j, int k) {

//      如果数组越界或者两个char不相等，return false
        if (board[i][j] != words[k] || i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
//      如果比较的是最后一个元素，则不再比较下去，return true
        if (k == words.length - 1) {
            return true;
        }
//      将此位置的字符置换，表示已经访问过了
        board[i][j] = '\0';
//      判断下一个字符是否相同
        boolean res = dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1)
                || dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1);
//      将board[i][j]的值还原，不影响之后的判断
        board[i][j] = words[k];
        return res;
    }

}
