package com.caleb.main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-09-22 09:33:14
 */
public class Main33 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int carCount = sc.nextInt();
			int cap = sc.nextInt();
			int funCar = 0;
			int[] inCar = new int[carCount+1];
			int[] outCar = new int[carCount+1];
			Set<Integer> inStop = new HashSet<>(cap);
			for (int i = 1; i <= carCount; i++) {
				int carNum = sc.nextInt();
				inCar[carNum] = i;
			}
			for (int i = 1; i <= carCount; i++) {
				outCar[i] = sc.nextInt();
			}
			for (int i = 1; i <= carCount; i++) {
				int carNum = outCar[i];
				if(inCar[carNum] - i + funCar >= cap){
					funCar++;
				}
			}
			System.out.println(funCar);

		}
	}

}