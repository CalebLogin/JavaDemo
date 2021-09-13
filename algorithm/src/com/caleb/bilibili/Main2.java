package com.caleb.bilibili;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-13 19:33:29
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			if (m == -1 && n == -1) {
				break;
			}
			sc.nextLine();
			int[][] matrix = new int[m][n];
			for (int i = 0; i < m; i++) {
				String[] strs = sc.nextLine().split(" ");
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(strs[j]);
				}
			}
			if (matrix.length == 0) {
				return;
			}
			int left = 0, right = matrix[0].length - 1, top = 0, bottom = m - 1;
			int numEle = m * n;
			List<Integer> list = new ArrayList<>();
			while (numEle >= 1) {
				for (int i = left; i <= right && numEle >= 1; i++) {
					list.add(matrix[top][i]);
					numEle--;
				}
				top++;
				for (int i = top; i <= bottom && numEle >= 1; i++) {
					list.add(matrix[i][right]);
					numEle--;
				}
				right--;
				for (int i = right; i >= left && numEle >= 1; i--) {
					list.add(matrix[bottom][i]);
					numEle--;
				}
				bottom--;
				for (int i = bottom; i >= top && numEle >= 1; i--) {
					list.add(matrix[i][left]);
					numEle--;
				}
				left++;
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
				if (i != list.size() - 1) {
					System.out.print(",");
				}
			}
			System.out.println();
		}
		sc.close();
	}

}