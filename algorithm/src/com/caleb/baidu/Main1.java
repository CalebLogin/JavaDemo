package com.caleb.baidu;

import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-07 19:44:11
 */
public class Main1 {

	public static void main1() {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int k = sc.nextInt();
		int[][] nums = new int[row][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				nums[i][j] = sc.nextInt();
			}
		}
		sc.close();
		for (int i = 0; i < row * k; i++) {
			for (int j = 0; j < row * k; j++) {
				System.out.print(nums[i / k][j/k]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		main1();
	}

}