package com.caleb.algorithm.leetcode;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * @author：hanzhigang
 * @Date : 2021/4/7 7:46 PM
 */
public class Rotate48 {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int row = 0;   // 记录当前的行和列
        int temp;
        int a,b,m,next;
        // 由外向里逐层遍历，一直遍历到之后一个元素或者没有元素
        while (row < len / 2) {
            // 遍历一行
            for (int i = row; i < len - row - 1; i++) {
                a = row;
                b = i;
                temp = matrix[a][b];
                for (int j = 0; j < 4; j++) {
                    m = a;
                    a = b;
                    b = len - 1 - m;
                    next = matrix[a][b];
                    matrix[a][b] = temp;
                    temp = next;
                }
            }
            row++;
        }
    }

}
