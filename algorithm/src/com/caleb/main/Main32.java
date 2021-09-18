package com.caleb.main;

import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-18 10:44:33
 */
public class Main32 {

	static int[][] allDirect = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static int changeDirect(int currPos, String direct) {
		if (direct.equals("left")) {
			currPos--;
			currPos = currPos < 0 ? 3 : currPos;
		} else {
			currPos = (currPos + 1) % 4;
		}
		return currPos;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		sc.nextLine();
		char[][] matrix = new char[row][col];
		for (int i = 0; i < row; i++) {
			matrix[i] = sc.nextLine().toCharArray();
		}
		int rowOffset = 0;
		int colOffset = 0;
		int rRow = 0;
		int rCol = 0;
		boolean flag = false;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 'R') {
					rRow = i;
					rCol = i;
					rowOffset = rRow;
					colOffset = rCol;
					flag = true;
					break;
				}
				if (flag) {
					break;
				}
			}
		}
		int currPos = 0;
		int rPos = allDirect[currPos][0], cPos = allDirect[currPos][1];
		int instructNum = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < instructNum; i++) {
			String[] instruct = sc.nextLine().split(" ");
			if (instruct[0].equals("Turn")) {
				String direct = instruct[1];
				currPos = changeDirect(currPos, direct);
				rPos = allDirect[0][0];
				cPos = allDirect[0][1];
			} else {
				int offSet = Integer.parseInt(instruct[1]);
				while (offSet != 0) {
					if (rowOffset + rPos >= 0 && rowOffset + rPos < row && colOffset + cPos >= 0
							&& colOffset + cPos < col && matrix[rowOffset + rPos][colOffset + cPos] != 'O') {
						rowOffset += rPos;
						colOffset += cPos;
					} else {
						break;
					}
					break;
				}
			}
		}
		sc.close();
		System.out.println((rowOffset - rRow) + " " + (colOffset - rCol));
	}

}