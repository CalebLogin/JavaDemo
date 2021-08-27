package com.caleb.hulu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-08-26 19:05:15
 */
public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		char[] res = s.toCharArray();
		sc.close();
		List<int[]> points = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = res[i];
			if (c != '.') {
				int direct = c == 'L' ? -1 : 1;
				points.add(new int[] { index++, direct, i });
				res[i] = 'X';
			}
		}
		int[] pos = new int[index];
		for (int[] is : points) {
			pos[is[0]] = is[2];
		}
		boolean isIn = true;
		StringBuffer stringBuffer = new StringBuffer();
		if(pos.length == 0){
			System.out.println(new String(res));
			return;
		}
		while (isIn) {
			stringBuffer.append(new String(res) + "\n");
			Arrays.fill(res, '.');
			int inCount = 0;
			for (int i = 0; i < index; i++) {
				if (pos[i] >= 0 && pos[i] < s.length()) {
					int[] ps = points.get(i);
					pos[i] = pos[i] + v * ps[1];
					if(pos[i] >= 0 && pos[i] < s.length()){
						inCount++;
						res[pos[i]] = 'X';
					}
				}
			}
			if (inCount == 0) {
				isIn = false;
			}
		}
		Arrays.fill(res, '.');
		stringBuffer.append(new String(res));

		System.out.println(stringBuffer.toString());

	}

}