package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 打开转盘锁 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7',
 * '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 锁的初始数字为
 * '0000' ，一个代表四个拨轮的数字的字符串。 列表 deadends
 * 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 字符串 target
 * 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * 
 * @author:Caleb
 * @Date :2021-06-25 09:47:24
 */
public class OpenLock752 {
	/**
	 * 穷举法 队列
	 * 
	 * @param deadends
	 * @param target
	 * @return
	 */
	public int openLock(String[] deadends, String target) {
		Map<String, Boolean> alreadyRead = new HashMap<>();
		for (String str : deadends) {
			alreadyRead.put(str, true);
		}
		if (target.equals("0000")) {
			return 0;
		}
		if (alreadyRead.getOrDefault("0000", false)) {
			return -1;
		}
		int step = 0;
		Queue<String> queue = new LinkedList<>();
		queue.offer(target);
		while (!queue.isEmpty()) {
			step++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				for (String nextStr : fastNum(queue.poll())) {
					if (!alreadyRead.getOrDefault(nextStr, false)) {
						if (nextStr.equals("0000")) {
							return step;
						}
						alreadyRead.put(nextStr, true);
						queue.offer(nextStr);
					}
				}
			}
		}
		return -1;
	}

	/**
	 * 双向BFS优先遍历
	 * 
	 * @param deadends
	 * @param target
	 * @return
	 */
	public int openLock1(String[] deadends, String target) {
		Set<String> visited = new HashSet<>();
		for (String deadLock : deadends) {
			visited.add(deadLock);
		}
		if (target.equals("0000")) {
			return 0;
		}
		if (visited.contains("0000") || visited.contains(target)) {
			return -1;
		}
		// 用两个set来模拟双向BFS
		Set<String> beginVisited = new HashSet<>();
		Set<String> endVisited = new HashSet<>();
		beginVisited.add(target);
		endVisited.add("0000");
		int step = 0;
		while(!beginVisited.isEmpty() && !endVisited.isEmpty()){
			if(beginVisited.size() > endVisited.size()){
				Set<String> temp = beginVisited;
				beginVisited = endVisited;
				endVisited = temp;
			}

			Set<String> nextLevelVisited = new HashSet<>();
			step++;
			for(String lock : beginVisited){
				visited.add(lock);
				for(String str : fastNum(lock)){
					if(!visited.contains(str)){
						if(endVisited.contains(str)){
							return step;
						}
						nextLevelVisited.add(str);
					}
				}
			}
			beginVisited = nextLevelVisited;
		}
		return -1;
	}

	/**
	 * 生成8种情况
	 * 
	 * @return
	 */
	private List<String> fastNum(String num) {
		List<String> list = new ArrayList<>();
		char[] cs = num.toCharArray();
		for (int i = 0; i < 4; i++) {
			char n = cs[i];
			cs[i] = numSucc(n);
			list.add(new String(cs));
			cs[i] = numPrev(n);
			list.add(new String(cs));
			cs[i] = n;
		}
		return list;
	}

	/**
	 * 生成x的前一个数字
	 * 
	 * @param x
	 * @return
	 */
	private char numPrev(char x) {
		return x == '0' ? '9' : (char) (x - 1);
	}

	/**
	 * 生成x的后一个数字
	 * 
	 * @param x
	 * @return
	 */
	private char numSucc(char x) {
		return x == '9' ? '0' : (char) (x + 1);
	}

}