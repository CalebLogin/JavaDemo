package com.caleb.baidu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-07 19:49:11
 */
public class Main3 {

	int[] nums;
	Queue<Integer> q;
	int n;
	int minV;
	public void main3() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		this.n = N;
		nums = new int[n + 1];
		int Q = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < Q; i++) {
			String s = sc.nextLine();
			q = new LinkedList<>();
			minV = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				nums[j + 1] = s.charAt(j) - 'A' + 1;
			}
			sort(1, -1);
			System.out.println(minV);
		}
		sc.close();
	}

	public void change(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void flip(int x) {
		for (int i = 1; i <= x / 2; i++) {
			change(i, x - i + 1);
		}
	}

	public void sort(int x, int last_flip) {
		if (isV()) {
			minV = Math.min(minV, q.size());
			return;
		}
		if (x > n) {
			return;
		}
		for (int i = 2; i <= n; i++) {
			if (i != last_flip) {
				flip(i);
				q.offer(i);
				sort(x + 1, i);
				flip(i);
				q.poll();
			}
		}
	}

	public boolean isV() {
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Main3 m = new Main3();
		m.main3();
	}

}