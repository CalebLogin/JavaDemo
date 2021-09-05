package com.caleb.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-09-03 20:35:33
 * 
 *       删除无效的括号
 * 
 *       给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 
 *       返回所有可能的结果。答案可以按 任意顺序 返回。
 * 
 */
public class RemoveInvalidParentheses301 {

	/**
	 * 广度优先遍历
	 * 
	 * @param s
	 * @return
	 */
	public List<String> removeInvalidParentheses(String s) {
		if (s == null) {
			return null;
		}
		List<String> res = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		Queue<String> q = new ArrayDeque<>();
		q.add(s);
		visited.add(s);
		boolean found = false;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String pollS = q.poll();
				if (isValid(pollS)) {
					res.add(pollS);
					found = true;
				}
				char[] cs = pollS.toCharArray();
				for (int j = 0; j < cs.length; j++) {
					if (cs[j] != '(' && cs[j] != ')') {
						continue;
					}
					String newS = new String(cs, 0, j) + new String(cs, j + 1, cs.length - j - 1);
					if (!visited.contains(newS)) {
						q.offer(newS);
						visited.add(newS);
					}

				}
			}
			if (found) {
				break;
			}
		}
		return res;
	}

	public boolean isValid(String s) {
		char[] cs = s.toCharArray();
		int count = 0;
		for (Character c : cs) {
			if (c == '(') {
				count++;
			}
			if (c == ')') {
				count--;
			}
			if (count < 0) {
				return false;
			}
		}
		return count == 0;
	}

	public static void main(String[] args) {
		RemoveInvalidParentheses301 r = new RemoveInvalidParentheses301();
		System.out.println(r.removeInvalidParentheses(")(").toString());
	}

}