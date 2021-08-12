package com.caleb.algorithm.review;

import java.util.Scanner;

/**
 * 贪心：线段覆盖
 * @author:Caleb
 * @Date :2021-06-15 22:06:34
 */
public class RepairFloor {

	/**
	 * 贪心算法，每次都取下标最新的作为地板的开始下标
	 * @return
	 */
	public int repairFloor() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int L = sc.nextInt();
		int[] totalFloors = new int[n];
		for (int count = 0; count < m; count++) {
			totalFloors[sc.nextInt()] = 1;
		}
		sc.close();
		// 左下标
		int left = 0;
		// 最终的地板数
		int finalCount = 0;
		while (left < n) {
			if (totalFloors[left] == 0) {
				left++;
			} else {
				for(int start = left;start < n && start < left+L;start++){
					totalFloors[start] = 0;
				}
				finalCount++;
				left += L;
			}
		}
		return finalCount;
	}

	public static void main(String[] args) {
		RepairFloor repairFloor = new RepairFloor();
		System.out.println(repairFloor.repairFloor());
	}

}