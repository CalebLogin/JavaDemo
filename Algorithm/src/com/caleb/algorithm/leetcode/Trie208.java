package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-06-30 09:13:30
 * 
 *       实现Trie(前缀树) Trie（发音类似 "try"）或者说 前缀树
 *       是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。 请你实现 Trie 类：
 *       Trie() 初始化前缀树对象。 void insert(String word) 向前缀树中插入字符串 word 。 boolean
 *       search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 *       boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回
 *       true ；否则，返回 false 。
 * 
 */
public class Trie208 {

	public static void main(String[] args) {

	}

}

class Trie1 {

	int[][] tries;
	int[] color;
	int k = 1;

	/** Initialize your data structure here. */
	public Trie1() {
		tries = new int[30000][26];
		color = new int[30000];
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		int len = word.length();
		int p = 0;
		for (int i = 0; i < len; i++) {
			int c = word.charAt(i) - 'a';
			if (tries[p][c] == 0) {
				tries[p][c] = k;
				k++;
			}
			p = tries[p][c];
		}
		color[p] = 1;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		int len = word.length();
		int p = 0;
		for (int i = 0; i < len; i++) {
			int c = word.charAt(i) - 'a';
			if (tries[p][c] == 0) {
				return false;
			} else {
				p = tries[p][c];
			}
		}
		return color[p] == 1;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		int len = prefix.length();
		int p = 0;
		for (int i = 0; i < len; i++) {
			int c = prefix.charAt(i) - 'a';
			if (tries[p][c] == 0) {
				return false;
			} else {
				p = tries[p][c];
			}
		}
		return true;
	}

}

class Trie {

	Trie[] children;
	boolean isEnd;

	public Trie() {
		children = new Trie[26];
	}

	public void insert(String word) {
		int len = word.length();
		Trie node = this;
		for (int i = 0; i < len; i++) {
			int c = word.charAt(i) - 'a';
			if (node.children[c] == null) {
				node.children[c] = new Trie();
			}
			node = node.children[c];
		}
		node.isEnd = true;
	}

	public boolean search(String word) {
		Trie node = searchPrefix(word);
		return node != null && node.isEnd;
	}

	public boolean startsWith(String prefix) {
		return searchPrefix(prefix) != null;
	}

	public Trie searchPrefix(String word) {
		Trie node = this;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			int c = word.charAt(i) - 'a';
			if (node.children[c] == null) {
				return null;
			}
			node = node.children[c];
		}
		return node;
	}

}
