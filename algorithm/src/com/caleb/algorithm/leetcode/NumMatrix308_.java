package com.caleb.algorithm.leetcode;

/**
 * 二维区域和检索 - 可变 给你一个 2D 矩阵 matrix，请计算出从左上角 (row1, col1) 到右下角 (row2, col2)
 * 组成的矩形中所有元素的和
 * 
 * @author:Caleb
 * @Date :2021-06-24 22:01:53
 */
public class NumMatrix308_ {

	public static void main(String[] args) {

	}

}

class NumMatrix {

	int[][] matrix;

	public NumMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void update(int row, int col, int val) {
		matrix[row][col] = val;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int res = 0;
		for (int i = row1; i <= row2; i++) {
			for (int j = col1; j <= col2; j++) {
				res += matrix[i][j];
			}
		}
		return res;
	}
}