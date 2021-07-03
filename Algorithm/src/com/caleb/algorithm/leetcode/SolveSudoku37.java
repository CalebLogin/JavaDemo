package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-07-02 22:03:47
 * 
 *       解数独
 * 
 *       编写一个程序，通过填充空格来解决数独问题。数独的解法需 遵循如下规则：
 *       数字 1-9 在每一行只能出现一次。数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的  3x3 宫内只能出现一次。
 *       （请参考示例图）数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 
 */
public class SolveSudoku37 {

	/**
	 * 基本思路：3x3的块内，一行，一列，三行，三列
	 * 
	 * @param board
	 */
	public void solveSudoku(char[][] board) {

	}

	/**
	 * 以3x3为单位，分别进行块内判断，行列判断，三行三列判断
	 * @param board
	 * @param boradNum 第几个3x3的矩形块
	 */
	private void solveSudokuHelper(char[][] board, int boradNum) {
		int minRow = (boradNum / 3) * 3;
		int maxRow = minRow + 3;
		int minCol = (boradNum % 3) * 3;
		int maxCol = minCol + 3;

	}

	/**
	 * 进行块内判断是否存在确定的数值
	 * @param board
	 * @param minRow
	 * @param minCol
	 */
	private void subBoardHelper(char[][] board,int minRow,int minCol){

	}

	/**
	 * 进行一行判断，是否存在确定的确定的数值
	 * @param board
	 * @param row
	 * @param col
	 */
	private void rowBoardHelper(char[][] board,int row,int col){
		
	}

	/**
	 * 进行一列判断，是否存在确定的确定的数值
	 * @param board
	 * @param row
	 * @param col
	 */
	private void colBoardHelper(char[][] board,int row,int col){
		
	}	

	/**
	 * 进行三列判断，是否存在确定的确定的数值
	 * @param board
	 * @param row
	 * @param col
	 */
	private void col3BoardHelper(char[][] board,int row,int col){
		
	}

	/**
	 * 进行三行判断，是否存在确定的确定的数值
	 * @param board
	 * @param row
	 * @param col
	 */
	private void row3BoardHelper(char[][] board,int row,int col){
		
	}

}