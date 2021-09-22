package com.caleb.main;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-22 15:35:11
 */
public class Main35 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] pos = new int[n];
		PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			p.add(new int[] { m, i });
		}
		int i = 0;
		while (!p.isEmpty()) {
			int[] ps = p.poll();
			pos[ps[1]] = ++i;
		}
		for(i = 0;i<n;i++){
			System.out.print(pos[i]);
			if(i != n-1){
				System.out.print(" ");
			}
		}
		System.out.println();
		sc.close();
	}

}