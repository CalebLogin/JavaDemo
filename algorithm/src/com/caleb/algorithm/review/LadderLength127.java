package com.caleb.algorithm.review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-09-03 21:23:47
 */
public class LadderLength127 {

	/**
	 * 广度优先遍历
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> allS = new HashSet<>(wordList);
		if (beginWord == endWord) {
			return 0;
		}
		if (!allS.contains(endWord)) {
			return 0;
		}
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		visited.add(beginWord);
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			count++;
			for (int i = 0; i < size; i++) {
				String pollS = q.poll();
				List<String> nexts = genAllS(pollS);
				for (String next : nexts) {
					if (allS.contains(next) && !visited.contains(next)) {
						if (next.equals(endWord)) {
							return count;
						}
						q.offer(next);
						visited.add(next);
					}
				}
			}
		}
		return 0;
	}

	public List<String> genAllS(String s) {
		List<String> res = new ArrayList<>();
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char preC = charArray[i];
			for (int j = 0; j < 26; j++) {
				if (('a' + j) == preC) {
					continue;
				}
				charArray[i] = (char) ('a' + j);
				res.add(new String(charArray));
			}
			charArray[i] = preC;
		}
		return res;
	}

	public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.size() == 0) {
			return 0;
		}
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		Set<String> dic = new HashSet<>(wordList);
		beginSet.add(beginWord);
		endSet.add(endWord);
		if (!dic.contains(endWord)) {
			return 0;
		}
		return bfs(beginSet, endSet, dic, 1);
	}

	public int bfs(Set<String> beginSet, Set<String> endSet, Set<String> dic, int l) {
		if (beginSet.size() == 0) {
			return 0;
		}
		if (beginSet.size() > endSet.size()) {
			return bfs(endSet, beginSet, dic, l);
		}
		dic.removeAll(beginSet);
		Set<String> nexts = new HashSet<>();
		for (String s : beginSet) {
			char[] arr = s.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char tmp = arr[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (tmp == c) {
						continue;
					}
					arr[i] = c;
					String next = new String(arr);
					if (dic.contains(next)) {
						if (endSet.contains(next)) {
							return l;
						}
						nexts.add(next);
					}
					arr[i] = tmp;
				}
			}
		}
		return bfs(nexts, endSet, dic, l + 1);
	}

}