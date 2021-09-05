package com.caleb.kuaishou;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-09-04 15:34:00
 */
public class Main {

	public int maxLen(String s) {
		Map<Character, Integer> map = new HashMap<>();
		char[] charArray = s.toCharArray();
		int max = Integer.MIN_VALUE;
		int l = 0;
		for (int r = 0; r < s.length(); r++) {
			char ch = charArray[r];
			if (map.containsKey(ch)) {
				l = Math.max(map.get(ch) + 1, l);
			}
			max = Math.max(max, r - l + 1);
			map.put(ch, r);
		}
		return max;
	}
	public static void main(String[] args) {
		
	}

}