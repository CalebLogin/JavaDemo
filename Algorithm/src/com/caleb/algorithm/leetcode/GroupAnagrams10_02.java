package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-07-18 23:28:39
 * 
 *       变位词组
 * 
 *       编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * 
 */
public class GroupAnagrams10_02 {

	/**
	 * 排序
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] numIndex = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				numIndex[i] = str.charAt(i);
			}
			Arrays.sort(numIndex);
			StringBuilder stringBuilder = new StringBuilder();
			for(Character c : numIndex){
				stringBuilder.append(c);
			}
			List<String> list = map.getOrDefault(stringBuilder.toString(), new ArrayList<>());
			list.add(str);
			map.put(stringBuilder.toString(), list);
		}
		for(Map.Entry<String,List<String>> entry : map.entrySet()){
			res.add(entry.getValue());
		}
		return res;
	}

	/**
	 * 计数
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams1(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();
		for(String str : strs){
			int[] charCount = new int[26];
			for(int i = 0;i<str.length();i++){
				charCount[str.charAt(i) - 'a']++;
			}
			StringBuilder stringBuilder = new StringBuilder();
			for(int i = 0;i<26;i++){
				if(charCount[i] != 0){
					stringBuilder.append('a' + i);
					stringBuilder.append(charCount[i]);
				}
			}
			
			List<String> list = map.getOrDefault(stringBuilder.toString(), new ArrayList<>());
			list.add(str);
			map.put(stringBuilder.toString(), list);
		}
		return new ArrayList<>(map.values());

	}



}