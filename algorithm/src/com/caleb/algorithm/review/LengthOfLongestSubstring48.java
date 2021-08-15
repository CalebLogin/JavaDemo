package com.caleb.algorithm.review;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-08-15 19:55:25
 */
public class LengthOfLongestSubstring48 {

	public int lengthOfLongestSubstring(String s) {
		int[] cPos = new int[128];
		Arrays.fill(cPos, -1);
		int left = -1, right = 0;
		int n = s.length();
		int maxRes = 0;
		while (right < n) {
			if (cPos[s.charAt(right)-1] != -1 && cPos[s.charAt(right) - 1] > left) {
				int pos = cPos[s.charAt(right) - 1];
				left = pos;
			}
			cPos[s.charAt(right) - 1] = right;
			maxRes = Math.max(maxRes, (right - left ));
			right++;
		}
		return maxRes;
	}

	public static void main(String[] args) {
		LengthOfLongestSubstring48 l = new LengthOfLongestSubstring48();
		System.out.println(l.lengthOfLongestSubstring(" "));
	}

}