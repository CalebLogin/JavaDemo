package com.caleb.pdd;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author:Caleb
 * @Date :2021-07-25 19:54:32
 */
public class Main2 {

	public void alg2() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] duoChicken = new int[count];
		int[] duoDick = new int[count];
		int countC = 0, countD = 0;

		for (int i = 0; i < count; i++) {
			duoChicken[i] = sc.nextInt();
		}
		for (int i = 0; i < count; i++) {
			duoDick[i] = sc.nextInt();
		}
		sc.close();
		int c = 0, d = 0;
		Stack<Integer> s = new Stack<>();
		int[] visited = new int[14];
		int index = 0;
		while (c < count && d < count) {
			int currC = duoChicken[c];
			int currD = duoDick[d];
			s.push(currC);
			index++;
			while (c < count && visited[s.peek()] != 0) {
				int last = s.pop();
				countC += index - last + 1;
				index -= (last + 1);
				while (!s.isEmpty()) {
					int num = s.pop();
					if (num != currC) {
						visited[num] = 0;
					} else {
						visited[num] = 0;
						break;
					}
				}
				c++;
				if (c < count) {
					index ++;
					s.push(duoChicken[c]);
					break;
				}
			}
			if (c < count) {
				visited[s.peek()] = index;
				c++;
			}
			s.push(currD);
			index++;
			while (d < count && visited[s.peek()] != 0) {
				int last = s.pop();
				countD += index - last + 1;
				index -= (last + 1);
				while (!s.isEmpty()) {
					int num = s.pop();
					if (num != currD) {
						visited[num] = 0;
					} else {
						visited[num] = 0;
						break;
					}
				}
				d++;
				if (d < count) {
					index++;
					s.push(duoDick[d]);
					break;
				}
			}
			if (d < count) {
				visited[s.peek()] = index;
				d++;
			}
		}
		if (c < count) {
			int currC = duoChicken[c];
			s.push(currC);
			index++;
			while (c < count && visited[s.peek()] != 0) {
				int last = s.pop();
				countC += index - last + 1;
				index -= (last + 1);
				while (!s.isEmpty()) {
					int num = s.pop();
					if (num != currC) {
						visited[num] = 0;
					} else {
						visited[num] = 0;
						break;
					}
				}
				c++;
				if (c < count) {
					s.push(duoChicken[c]);
					index++;
					break;
				}
			}
			while (c < count) {
				s.push(duoChicken[c++]);
			}
		}
		if (d < count) {
			int currD = duoDick[c];
			s.push(currD);
			index++;
			while (d < count && visited[s.peek()] != 0) {
				int last = s.pop();
				countD += index - last + 1;
				index -= (last + 1);
				while (!s.isEmpty()) {
					int num = s.pop();
					if (num != currD) {
						visited[num] = 0;
					} else {
						visited[num] = 0;
						break;
					}
				}
				d++;
				if (d < count) {
					s.push(duoDick[d]);
					break;
				}
			}
			if (d < count) {
				s.push(duoDick[d++]);
			}
		}
		while(!s.isEmpty()){
			int num = s.pop();
			if(num % 2 == 0){
				countD++;
			}else{
				countC++;
			}
		}
		System.out.println(countC + " " + countD);

	}

	public static void main(String[] args) {
		Main2 m =new Main2();
		m.alg2();
	}

}