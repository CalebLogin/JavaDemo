package com.caleb.algorithm.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 至多包含k个不同字符的最长子串
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 * @author:Caleb
 * @Date :2021-06-15 08:55:09
 */
public class LengthOfLongestSubstringKDistinct340 {

	/**
	 * hash表
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {

		Map<Character, Integer> map = new HashMap<>();
		int len = s.length();
		int l = 0, r = 0;
		// 记录最大长度
		int max = Integer.MIN_VALUE;
		int count = 0;
		while (r < len) {
			if ((r - l) < k) {
				map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
				if(map.get(s.charAt(r)) == 1){
					count++;
				}
				r++;
			} else {
				map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
				if(map.get(s.charAt(r)) == 1){
					count++;
				}
				if (count > k) {
					boolean flag = true;
					while (l <= r && flag) {
						map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
						if (map.get(s.charAt(l)) == 0) {
							flag = false;
							count--;
						}
						l++;
					}
				}
				r++;
			}
			max = Math.max(max, r - l);
		}
		return max;

	}

	/**
	 * LRU
	 * @param s
	 * @param k
	 * @return
	 */
	public int lengthOfLongestSubstringKDistinct1(String s, int k) {

		Map<Character, Integer> map = new HashMap<>();
		int len = s.length();
		int l = 0, r = 0;
		// 记录最大长度
		int max = Integer.MIN_VALUE;
		while(r < len){
			map.put(s.charAt(r), r++);
			if(map.size() > k){
				int leftMost = Collections.min(map.values());
				map.remove(s.charAt(leftMost));
				l = leftMost + 1;
			}
			max = Math.max(max, r - l);
		}
		return max;

	}

	public static void main(String[] args) {
		LengthOfLongestSubstringKDistinct340 l = new LengthOfLongestSubstringKDistinct340();
		System.out.println(l.lengthOfLongestSubstringKDistinct1("aa", 1));
	}

}