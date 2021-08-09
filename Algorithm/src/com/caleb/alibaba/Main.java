package com.caleb.alibaba;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-08-06 19:09:52
 */
public class Main {

	public static void newWorld() {
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int m = sc.nextInt();
		int w = sc.nextInt();
		int i = sc.nextInt();
		int j = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		long dayCount = (k - 1) * m * d;
		dayCount += (j - 1) * d;
		dayCount += i;
		dayCount -= 1;
		dayCount %= w;
		char dayC = (char) ('a' + dayCount);
		System.out.println(dayC);
	}

	public static void niuniu() {
		List<Set<Integer>> leagues = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			if(t == 2){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				int num1 = a % c;
				int num2 = b % c;
				if(num1 == num2){
					System.out.println("YES");
				}else{
					boolean flag = false;
					for(Set<Integer> set : leagues){
						if(set.contains(num1) && set.contains(num2)){
							flag = true;
							System.out.println("YES");
							break;
						}
					}
					if(!flag){
						System.out.println("NO");
					}	
				}
			}else{
				int a = sc.nextInt();
				int b = sc.nextInt();
				boolean flag = false;
				for(Set<Integer> set : leagues){
					if(set.contains(a) || set.contains(b)){
						flag = true;
						set.add(a);
						set.add(b);
						break;
					}
				}
				if(!flag){
					Set<Integer> newSet = new HashSet<>();
					newSet.add(a);
					newSet.add(b);
					leagues.add(newSet);
				}
			}
		}
		sc.close();
	}

	public static void main(String[] args) {
		niuniu();
	}

}