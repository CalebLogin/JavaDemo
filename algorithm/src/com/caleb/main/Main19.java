package com.caleb.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-08-31 19:35:18
 */
public class Main19 {
	private static char[] cs;

	public static String getRes(String s) {
		cs = s.toCharArray();
		int len = s.length();
		return getResHelper(0, len - 1, 1);
	}

	public static String getResHelper(int l, int r, int n) {
		if (l > r) {
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		int lC = 0;
		int left = l, right = r;
		int preL = left;
		while (left <= right) {
			if (cs[left] == '[') {
				lC++;
				if (lC == 1) {
					preL = left;
				}
			} else if (cs[left] == ']') {
				lC--;
				if (lC == 0) {
					stringBuilder.append(getResHelper(preL + 1, left - 1, Integer.parseInt(cs[preL - 2] + "")));
				}
			} else if(lC == 0 && !((left == right && cs[left] == ']')||(left +1 <= right && cs[left + 1] == '[')||(left + 2 <= right && cs[left+2] == '['))){
				stringBuilder.append(cs[left]);
			}
			left++;
		}
		String ss = stringBuilder.toString();
		for (int i = 1; i < n; i++) {
			
			stringBuilder.append(ss);
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		System.out.println(getRes("3"));
	}

}