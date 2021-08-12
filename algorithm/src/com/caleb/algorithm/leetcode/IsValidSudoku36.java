package com.caleb.algorithm.leetcode;

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * @author：hanzhigang
 * @Date : 2021/4/6 7:52 PM
 */
public class IsValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] flag = new int[3][3];
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i + m][j + n] != '.') {
                            flag[m][n] = board[i + m][j + n] - '0';
                        }else{
                            flag[m][n] = 0;
                        }

                    }
                }
                if (!isValid(board, flag, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int[][] flag, int row, int col) {
        int[] temp = new int[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (flag[i][j] != 0) {
                    int rowIndex = row + i;
                    int colIndex = col + j;
                    // 判断3x3内数字是否重复
                    if (temp[flag[i][j]] >= 1) {
                        return false;
                    } else {
                        temp[flag[i][j]]++;
                    }
                    for (int start = 0; start < 9; start++) {
                        // 判断一列内是否出现重复
                        if (start != colIndex && board[rowIndex][start] - '0' == flag[i][j]) {
                            return false;
                        }
                        // 判断一行内是否出现重复
                        if (start != rowIndex && board[start][colIndex] - '0' == flag[i][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
