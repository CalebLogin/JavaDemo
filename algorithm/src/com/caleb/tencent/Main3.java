package com.caleb.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-09-05 21:07:02
 */
public class Main3 {

	public static void numS() {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int l = sc.nextInt();
		int r = sc.nextInt();
		List<Long> list = new ArrayList<>();
		list.add(n);
		while (n > 1) {
			list.add(n / 2);
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
				res.addAll(ll);
			}
		}
		int resC = 0;
		System.out.println(res.toString());
		for (int i = l - 1; i < r; i++) {
			if (res.get(i) == 1) {
				resC++;
			}
		}
		System.out.println(resC);

	}

	public static void main(String[] args) {
		numS();
	}

}