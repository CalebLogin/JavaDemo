package com.eric.alorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 11:51 PM
 */
public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        int rowIndex = 0;   // 当前访问的行下标
        int colIndex = 0;   // 当前访问的列下标
        int maxRow = matrix.length - 1; // 当前访问时能达到的最大行下标
        int minRow = 0; // 当前访问时能达到的最小行下标
        int maxCol = matrix[0].length - 1;  // 当前访问时能达到的最大列下标
        int minCol = 0; // 当前访问时能达到的最小列下边
        int size = matrix.length * matrix[0].length;   // 当前剩余的元素

        List<Integer> list = new ArrayList<>();

        while (size > 0) {
            // 向右横向遍历，不能超过maxCol
            while (colIndex <= maxCol) {
                list.add(matrix[rowIndex][colIndex]);
                colIndex++;
                size--;
            }
            if (size <= 0) {
                break;
            }
            rowIndex++; // 将行指向下一行
            colIndex--; // 将列指向能达到的最大列
            minRow++;   // 最小行遍历完，指向下一行

            // 向下纵向遍历，不能超过maxRow
            while (rowIndex <= maxRow) {
                list.add(matrix[rowIndex][colIndex]);
                rowIndex++;
                size--;
            }
            if (size <= 0) {
                break;
            }
            maxCol--;   // 最大列遍历完，指向前一列
            rowIndex--; // 将行指向能达到的最大行
            colIndex--; // 将列指向左一列

            // 向左横向遍历，不能超过最小列
            while (colIndex >= minCol) {
                list.add(matrix[rowIndex][colIndex]);
                colIndex--;
                size--;
            }
            if (size <= 0){
                break;
            }
            maxRow--;   // 最大行遍历完，指向上一行
            colIndex++; // 将列指向最小列
            rowIndex--; // 当前行遍历完，指向上一行

            // 向上纵向遍历，不能超过最小行
            while(rowIndex >= minRow){
                list.add(matrix[rowIndex][colIndex]);
                rowIndex--;
                size--;
            }
            rowIndex++; // 指向能达到的最小行
            colIndex++; // 当前列遍历完，指向下一列
            minCol++;   // 最小列遍历完，指向下一列
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralOrder54 spiralOrder54 = new SpiralOrder54();
        spiralOrder54.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
