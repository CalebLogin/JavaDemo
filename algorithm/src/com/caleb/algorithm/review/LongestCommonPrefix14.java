package com.caleb.algorithm.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-08-15 17:17:07
 */
public class LongestCommonPrefix14 {

	public String longestCommonPrefix(String[] strs) {
		Trie1 node = new Trie1();
		for(String str : strs){
			node.insert(str);
		}
		int count = 0;
		Map<Character,Trie1> currM;
		while((currM = node.map).size() == 1 && !node.isEnd){
			count++;
			for(Map.Entry<Character,Trie1> entry : currM.entrySet()){
				node = entry.getValue();
			}
		}
		return strs[0].substring(0, count);
	}

	public static void main(String[] args) {
		LongestCommonPrefix14 l = new LongestCommonPrefix14();
		System.out.println(l.longestCommonPrefix(new String[]{"flower","flow","flight"}));
	}

}

class Trie1 {
	Map<Character, Trie1> map;
	boolean isEnd;

	public Trie1() {
		map = new HashMap<>();
	}

	void insert(String str) {
		char[] cs = str.toCharArray();
		Trie1 currNode = this;
		for (Character c : cs) {
			if (!currNode.map.containsKey(c)) {
				currNode.map.put(c, new Trie1());
			}
			currNode = currNode.map.get(c);
		}
		currNode.isEnd = true;
	}

	Trie1 searchPrefix(String str) {
		Trie1 currNode = this;
		char[] cs = str.toCharArray();
		for (Character c : cs) {
			if (!currNode.map.containsKey(c)) {
				return null;
			}
			currNode = currNode.map.get(c);
		}
		return currNode;
	}

}