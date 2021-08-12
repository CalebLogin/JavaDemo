package com.caleb.algorithm.leetcode;

/**
 * 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 问题：怎么解决置0之后重复置零的问题
 * @author：hanzhigang
 * @Date : 2021/4/10 9:18 PM
 */
public class SetZeroes73 {
    /**
     * 设置两个变量，记录第一行是否存在0，第一列是否存在0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean rowFlag = false;    // true表示第一行存在0
        // 查找第一行是否存在0
        for(int i = 0;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                rowFlag = true;
                break;
            }
        }
        // 查找第一列是否存在0
        boolean colFlag = false;    // true表示第一列存在0
        for(int j = 0; j<matrix.length; j++){
            if(matrix[j][0] == 0){
                colFlag = true;
                break;
            }
        }

        // 在遍历过程中出现0，则将对应第一行的元素和第一列的元素置为0
        for(int i = 1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 将对应第一行和第一列为0的元素所在的列和行的元素全部置为0
        for(int i = 1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowFlag){
            for(int i = 0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
        if(colFlag){
            for(int j = 0;j<matrix.length;j++){
                matrix[j][0] = 0;
            }
        }
    }
}
