package com.caleb.bilibili;

import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-13 20:22:43
 */
public class Main3 {

	public static void alg() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] intX = new int[500001];
		int[] intY = new int[500001];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			intX[x]++;
			intY[y]++;
		}
		sc.close();
		int res = Integer.MIN_VALUE;
		for (int xx : intX) {
			if (xx > res) {
				res = xx;
			}
		}
		for (int yy : intY) {
			if (yy > res) {
				res = yy;
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		alg();
	}

}