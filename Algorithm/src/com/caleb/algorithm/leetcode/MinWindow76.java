package com.caleb.algorithm.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-06-27 10:15:00
 * 
 *       最小覆盖子串
 * 
 *       给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖
 *       t所有字符的子串，则返回空字符串""。 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 
 */
public class MinWindow76 {

	/**
	 * 滑动窗口 队列 最后一个测试用例没过
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
		// 记录遍历过程中各个字符还需要出现的次数，大于0表示还需要多少个，小于0表示多出来多少个，0表示正好
		Map<Character, Integer> need = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
		}
		Deque<int[]> deque = new LinkedList<>();

		// 字符串的长度
		int len = s.length();
		int right = 0;
		int minLeft = -1;
		int minLen = len;
		// 记录字符串t中出现的总的字符的个数，当count == 0 时表示当前队列中存在满足t条件的字符串
		int count = t.length();
		while (right < len) {
			// 记录t中每个字符在s中出现的最新的位置
			if (need.containsKey(s.charAt(right))) {
				if (need.get(s.charAt(right)) > 0) {
					count--;
				}
				need.put(s.charAt(right), need.getOrDefault(s.charAt(right), 0) - 1);
				deque.offer(new int[] { s.charAt(right), right });
			}

			while (!deque.isEmpty() && need.get((char) (deque.peekFirst()[0])) < 0) {
				char dp = (char) (deque.pollFirst()[0]);
				need.put(dp, need.get(dp) + 1);
			}
			if (count == 0) {
				int leftPos = deque.peekFirst()[1];
				int rightPos = deque.peekLast()[1];
				int currentLen = rightPos - leftPos + 1;
				if (currentLen <= minLen) {
					minLen = currentLen;
					minLeft = leftPos;
				}
				char dp = (char) (deque.pollFirst()[0]);
				need.put(dp, need.get(dp) + 1);	
				count ++;
			}
			right++;
		}
		return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minLen);
	}

	/**
	 * 通过数组的形式
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow1(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}
		int[] cnt = new int[128];
		for (int i = 0; i < t.length(); i++) {
			cnt[t.charAt(i)]++;
		}
		int count = t.length();
		int r = 0, l = 0, minLen = Integer.MAX_VALUE, start = 0;
		int len = s.length();
		while (r < len) {
			char rc = s.charAt(r);
			// 如果遍历到的当前的字符是需要的
			if (cnt[rc] > 0) {
				count--;
			}
			cnt[rc]--;
			// 将左边多出来的字符删除
			while (l < r && cnt[s.charAt(l)] < 0) {
				cnt[s.charAt(l)]++;
				l++;
			}
			if (count == 0) {
				int currLen = r - l + 1;
				if (currLen < minLen) {
					start = l;
					minLen = currLen;
				}
				// 触发进行寻找新的字符串
				cnt[s.charAt(l)]++;
				l++;
				count++;
			}
			r++;
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
	}

	public static void main(String[] args) {
		MinWindow76 m = new MinWindow76();
		System.out.println(m.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
	}

}