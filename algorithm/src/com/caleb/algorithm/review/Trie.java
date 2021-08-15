package com.caleb.algorithm.review;

public class Trie {

	private boolean isEnd;
	private Trie[] children;

	public Trie() {
		isEnd = false;
		children = new Trie[26];
	}

	public void insert(String str) {
		Trie currNode = this;
		for (Character c : str.toCharArray()) {
			if (currNode.children[c - 'a'] == null) {
				currNode.children[c - 'a'] = new Trie();
			}
			currNode = currNode.children[c - 'a'];
		}
		currNode.isEnd = true;
	}

	public boolean search(String str) {
		Trie node = searchPrefix(str);
		return node != null && node.isEnd;
	}

	public boolean startsWith(String str) {
		return searchPrefix(str) != null;
	}

	public Trie searchPrefix(String str) {
		Trie node = this;
		for (int i = 0; i < str.length(); i++) {
			if (node.children[str.charAt(i) - 'a'] == null) {
				return null;
			} else {
				node = node.children[str.charAt(i) - 'a'];
			}
		}
		return node;
	}
}