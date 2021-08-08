package com.caleb.algorithm.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-08-07 16:42:35
 */
public class Partition131 {

	boolean[][] pa;
	private List<List<String>> res;
	private List<String> list = new ArrayList<>();

	public List<List<String>> partition(String s) {
		int n = s.length();
		char[] cs = s.toCharArray();
		res = new ArrayList<>();
		// 进行优化，首先寻找字符串中所有的回文串
		pa = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(pa[i], true);
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				pa[i][j] = pa[i + 1][j - 1] && (cs[i] == cs[j]);
			}
		}
		dfs(cs, 0);
		return res;
	}

	private void dfs(char[] cs, int start) {
		if (start == cs.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < cs.length; i++) {
			if (pa[start][i]) {
				list.add(new String(cs, start, i - start + 1));
				dfs(cs, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Partition131 p = new Partition131();
		System.out.println(p.partition("aab").toString());
	}

}