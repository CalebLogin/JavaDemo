package com.caleb.main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main22 {

	long res = 0;
	Set<Integer> visited;

	public void goodFriend() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long K = sc.nextLong();
		sc.nextLine();
		String allP = sc.nextLine();
		String[] allPs = allP.split(" ");
		sc.close();
		int[][] adjacentM = new int[N + 1][N + 1];
		for (int i = 0; i < allPs.length; i += 3) {
			adjacentM[Integer.parseInt(allPs[i])][Integer.parseInt(allPs[i + 1])] = Integer.parseInt(allPs[i + 2]);
			adjacentM[Integer.parseInt(allPs[i + 1])][Integer.parseInt(allPs[i])] = Integer.parseInt(allPs[i + 2]);
		}
		for (int i = 1; i <= N; i++) {
			visited = new HashSet<>();
			visited.add(i);
			bfs(adjacentM, i, i, 0, K,N);
		}
		System.out.println(res / 2);

	}

	public void bfs(int[][] adjacentM, int s, int next, int v, long K,int n) {
		for (int i = 1; i <= n; i++) {
			if (adjacentM[next][i] != 0) {
				if (v + adjacentM[next][i] <= K && !visited.contains(i)) {
					res++;
					visited.add(i);
					bfs(adjacentM, s, i, v + adjacentM[next][i], K,n);
				}
			}
		}
	}

	public static void main(String[] args) {
		Main22 m = new Main22();
		m.goodFriend();
	}

}