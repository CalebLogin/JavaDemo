package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-07-12 17:08:13
 *
 *       单词搜索II
 * 
 *       给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 
 *       单词必须按照字母顺序，通过 相邻的单元格
 *       内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 
 */
public class FindWords212 {

	Set<String> res;
	Set<String> preSet;
	Set<String> set;
	int[] pos = { -1, 1 };
	boolean[][] visited;
	List<Character> s = new ArrayList<>();

	/**
	 * 暴力求解，超时
	 * 
	 * @param board
	 * @param words
	 * @return
	 */
	public List<String> findWords(char[][] board, String[] words) {
		int row = board.length;
		int col = board[0].length;
		visited = new boolean[row][col];
		res = new HashSet<>();
		set = new HashSet<>();
		preSet = new HashSet<>();
		for (String str : words) {
			for (int j = 1; j <= str.length(); j++) {
				preSet.add(str.substring(0, j));
			}
			set.add(str);
		}
		System.out.println(preSet.toString());
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (preSet.contains(board[i][j] + "")) {
					visited[i][j] = true;
					s.add(board[i][j]);
					dfs(board, i, j);
					s.clear();
					visited[i][j] = false;
				}
			}
		}
		return new ArrayList<>(res);
	}

	private void dfs(char[][] board, int i, int j) {
		StringBuilder str = new StringBuilder();
		for (Character c : s) {
			str.append(c);
		}
		if (set.contains(str.toString())) {
			res.add(str.toString());
		}
		visited[i][j] = true;
		for (int m = 0; m < 2; m++) {
			int x = i + pos[m];
			int y = j;
			if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && !visited[x][y]) {
				s.add(board[x][y]);
				StringBuilder str1 = new StringBuilder();
				for (Character c : s) {
					str1.append(c);
				}
				if (preSet.contains(str1.toString())) {
					visited[x][y] = true;
					dfs(board, x, y);
					visited[x][y] = false;
				}
				s.remove(s.size() - 1);
			}
			x = i;
			y = j + pos[m];
			if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && !visited[x][y]) {
				s.add(board[x][y]);
				StringBuilder str2 = new StringBuilder();
				for (Character c : s) {
					str2.append(c);
				}
				if (preSet.contains(str2.toString())) {
					visited[x][y] = true;
					dfs(board, x, y);
					visited[x][y] = false;
				}
				s.remove(s.size() - 1);
			}
		}
	}
	// public List<String> findWords1(char[][] board, String[] words) {

	// }

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		FindWords212 f = new FindWords212();
		List<String> res = f.findWords(board, words);
		System.out.println(res.toString());
	}

}