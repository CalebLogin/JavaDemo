package com.caleb.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:Caleb
 * @Date :2021-08-01 19:15:47
 * 
 *       矩阵中战斗力最弱的K行
 * 
 *       给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 
 *       请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * 
 *       如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 
 *       军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 */
public class KWeakestRows {

	/**
	 * 排序
	 * 
	 * @param mat
	 * @param k
	 * @return
	 */
	public int[] kWeakestRows(int[][] mat, int k) {
		int[][] fightingV = new int[mat.length][2];
		for (int i = 0; i < mat.length; i++) {
			int[] singleMat = mat[i];
			int currFight = 0;
			for (Integer v : singleMat) {
				if (v != 0) {
					currFight += v;
				} else {
					break;
				}
			}
			fightingV[i] = new int[] { i, currFight };
		}
		Arrays.sort(fightingV, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}

		});
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = fightingV[i][0];
		}
		return res;
	}

	/**
	 * 冒泡排序
	 * 
	 * @param mat
	 * @param k
	 * @return
	 */
	public int[] kWeakestRows1(int[][] mat, int k) {
		int[][] fightingV = new int[mat.length][2];
		int m = mat.length;
		int n = mat[0].length;
		int[] res = new int[k];
		for (int i = 0; i < m; ++i) {
			int l = 0, r = n - 1, pos = -1;
			while (l <= r) {
				int mid = (l + r) / 2;
				if (mat[i][mid] == 0) {
					r = mid - 1;
				} else {
					pos = mid;
					l = mid + 1;
				}
			}
			fightingV[i] = new int[] { i, pos + 1 };
		}
		for (int i = 0; i < k; i++) {
			for (int j = fightingV.length - 1; j > i; j--) {
				int pre = fightingV[j - 1][1];
				int curr = fightingV[j][1];
				if (pre > curr) {
					int[] temp = fightingV[j - 1];
					fightingV[j - 1] = fightingV[j];
					fightingV[j] = temp;
				}
			}
			res[i] = fightingV[i][0];
		}
		return res;
	}

}