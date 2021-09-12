package com.caleb.jd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-11 20:14:06
 */
public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		Map<Character, int[]> map = new HashMap<>();
		char[][] matrix = new char[n][m];
		for (int i = 0; i < n; i++) {
			matrix[i] = sc.next().toCharArray();
			for (int j = 0; j < matrix[i].length; j++) {
				map.put(matrix[i][j], new int[] { i, j });
			}
		}
		char[] target = sc.next().toCharArray();
		sc.close();
		int[] pos = new int[] { 0, 0 };
		long res = 0;
		for (int i = 0; i < target.length; i++) {
			int curX = pos[0];
			int curY = pos[1];
			char c = target[i];
			int[] end = map.get(c);
			int endX = end[0];
			int endY = end[1];
			if (curX == endX && curY == endY) {
				res += z;
			} else if (curX == endX) {
				res += Math.abs(curY - endY) * x + z;
			} else if (curY == endY) {
				res += Math.abs(curX - endX) * x + z;
			} else {
				res += Math.abs(curY - endY) * x + Math.abs(curX - endX) * x + y + z;
			}
			pos = end;
		}
		System.out.println(res);
	}

}