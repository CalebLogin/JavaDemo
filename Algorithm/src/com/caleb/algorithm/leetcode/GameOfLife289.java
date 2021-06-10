package com.caleb.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 289生命游戏
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * 给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 * @author：hanzhigang
 * @Date : 2021/6/9 10:47 PM
 */
public class GameOfLife289 {

    /**
     * 新建数组的想法
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[1].length;
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                if (i - 1 >= 0) {
                    count += board[i - 1][j];
                    if (j - 1 >= 0) {
                        count += board[i - 1][j - 1];
                    }
                    if (j + 1 < col) {
                        count += board[i - 1][j + 1];
                    }
                }
                if (j - 1 >= 0) {
                    count += board[i][j - 1];
                }
                if (j + 1 < col) {
                    count += board[i][j + 1];
                }
                if (i + 1 < row) {
                    count += board[i + 1][j];
                    if (j - 1 >= 0) {
                        count += board[i + 1][j - 1];
                    }
                    if (j + 1 < col) {
                        count += board[i + 1][j + 1];
                    }
                }
                if(board[i][j] == 1){
                    if(count < 2 || count > 3){
                        temp[i][j] = 0;
                    }
                }
                if(board[i][j] == 0 && count == 3){
                    temp[i][j] = 1;
                }
            }
        }
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                board[i][j] = temp[i][j];
            }
        }
    }

    /**
     * 栈的思想
     * 创建标记数组
     * @param board
     */
    public void gameOfLife1(int[][] board) {

        int row = board.length;
        int col = board[0].length;

        boolean[][] flags = new boolean[row][col];
        for(int i = 0;i<row;i++){
            Arrays.fill(flags[i],false);
        }
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(!flags[i][j]){
                    Stack<int[]> stack = new Stack<>();
                    stack.add(new int[]{i,j});
                    while(!stack.isEmpty()){

                    }
                }
            }
        }


    }
}
