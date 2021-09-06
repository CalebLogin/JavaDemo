package com.caleb.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-05 21:07:02
 */
public class Main4 {

	public static void numS() {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int l = sc.nextInt();
		int r = sc.nextInt();
		sc.close();
		List<Long> list = new ArrayList<>();
		while (n > 1) {
			list.add(n);
			n /= 2;
		}
		Collections.reverse(list);
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 2) {
				res.add(1);
				res.add(0);
				res.add(1);
			} else if (list.get(i) == 3) {
				res.add(1);
				res.add(1);
				res.add(1);
			} else {
				List<Integer> ll = new ArrayList<>(res);
				res.add((int) (list.get(i) % 2));
				Collections.reverse(ll);
				res.addAll(ll);
			}
		}
		int resC = 0;
		for (int i = l - 1; i < r; i++) {
			resC += res.get(i);
		}
		System.out.println(resC);

	}

	public static void main(String[] args) {
		numS();
	}

}