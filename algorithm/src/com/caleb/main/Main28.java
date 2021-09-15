package com.caleb.main;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author:Caleb
 * @Date :2021-09-14 20:19:24
 */
public class Main28 {

	static Stack<Long> stack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long Q = sc.nextLong();
		stack = new Stack<>();
		stack.add(N);
		stack.add(1L);
		for (int i = 1; i <= Q; i++) {
			long move = sc.nextLong();
			if (move == 0) {
				long start = stack.peek();
				stack.add(start - 1);
				stack.add(start - 1);
				System.out.println(0);
			} else {
				System.out.println(leftNum(move));
			}
		}
		sc.close();
	}

	public static long leftNum(long move) {
		long start = stack.pop();
		long end = stack.pop();
		if (end - start > move) {
			stack.add(end);
			stack.add(start + move + 1);
			stack.add(start + move - 1);
			stack.add(start);
			return move;
		} else if (end - start == move) {
			stack.add(end - 1);
			stack.add(start);
			return move;
		} else {
			long res = end - start + 1;
			long currMove = move - (end - start);
			while (!stack.isEmpty()) {
				long pres = stack.pop();
				long pree = stack.pop();
				long leftV = pres - (move - currMove + 1);
				if (pree - pres + 1 > currMove) {
					stack.add(pree);
					stack.add(pres + currMove + 1);
					stack.add(start + move - 1);
					stack.add(start);
					return res + currMove * (leftV + 1);
				} else if (pree - pres + 1 == currMove) {
					stack.add(pree - leftV);
					stack.add(start);
					return res + currMove;
				} else {
					res += pree - pres;
					currMove -= (pree - pres);
					if (stack.isEmpty()) {
						stack.add(start + (move - currMove + 1));
						stack.add(start);
						return res;
					}
				}
			}
			stack.add(end - 1);
			stack.add(start);
			return res;
		}
	}

}