package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-06-21 12:25:47
 * 
 *       串联所有单词的子串
 * 
 *       给定一个字符串 s 和一些 长度相同 的单词 words 。
 * 
 *       找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 
 *       注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * 
 *       输入：s = "barfoothefoobarman", words = ["foo","bar"] 输出：[0,9] 解释： 从索引 0 和
 *       9 开始的子串分别是 "barfoo" 和 "foobar" 。 输出的顺序不重要, [9,0] 也是有效答案。
 */
public class FindSubstring30 {

	/**
	 * 滑动窗口的思想
	 * 
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		int[] firstNames = new int[26];
		Map<String, Integer> wordCount = new HashMap<>();
		int finalLen = 0;
		int wordLen = words[0].length();
		List<Integer> res = new ArrayList<>();
		// 记录每个单词出现的个数
		for (String word : words) {
			firstNames[word.charAt(0) - 'a']++;
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
			finalLen += word.length();
		}
		for (int i = 0; i <= s.length() - finalLen; i++) {
			// 记录滑动窗口内的单词个数
			Map<String, Integer> map = new HashMap<>();
			if (firstNames[s.charAt(i) - 'a'] != 0) {
				// 记录是否全部相同
				boolean flag = true;
				for (int j = 0; j < finalLen; j += wordLen) {
					map.put(s.substring(j + i, i + j + wordLen),
							map.getOrDefault(s.substring(i + j, i + j + wordLen), 0) + 1);
				}
				for (String key : map.keySet()) {
					if (map.get(key) != wordCount.getOrDefault(key, 0)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					res.add(i);
				}
			}
		}
		return res;
	}

	/**
	 * 滑动窗口的思想
	 * 
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstring1(String s, String[] words) {
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return null;
		}
		List<Integer> res = new ArrayList<>();
		int oneWord = words[0].length(); // 一个单词的长度
		int wordNum = words.length; // 单词个数
		Map<String, Integer> wordCount = new HashMap<>(); // 记录每个单词出现的次数
		for (String word : words) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}
		for (int i = 0; i < oneWord; i++) {
			int left = i, right = i, count = 0; // 记录窗口的左右边界
			Map<String, Integer> temp = new HashMap<>();
			while (right + oneWord <= s.length()) {
				// 将最新单词加入哈希中
				String word = s.substring(right, right + oneWord);
				temp.put(word, temp.getOrDefault(word, 0) + 1);
				count++;
				right += oneWord;
				// 如果当前加入的单词比给定的单词数量多，出窗口左边的单词。最坏的情况是一直遍历到新加入的单词出窗口，当前窗口变为空。
				while (temp.getOrDefault(word, 0) > wordCount.getOrDefault(word, 0)) {
					String tempWord = s.substring(left, left + oneWord);
					left += oneWord;
					temp.put(tempWord, temp.getOrDefault(tempWord, 0) - 1);
					count--;
				}
				// 如果个数相同说明窗口内的单词恰好等于给定的单词
				if (count == wordNum) {
					res.add(left);
				}
			}
		}

		return res;

	}

	public static void main(String[] args) {
		FindSubstring30 f = new FindSubstring30();
		List<Integer> res = f.findSubstring("wordgoodgoodgoodbestword",
				new String[] { "word", "good", "best", "good" });
		System.out.println(res.toString());
	}

}