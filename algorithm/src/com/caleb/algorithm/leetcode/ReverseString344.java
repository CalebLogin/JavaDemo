package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date  :2021-06-14 23:36:30
 */
public class ReverseString344{

	public void reverseString(char[] s) {
		int len = s.length;
		for(int i = 0;i<s.length/2;i++){
			char t = s[i];
			s[i] = s[len - 1 - i];
			s[len - 1 - i] = t;
		}

    }

}
