package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-06-26 15:34:32
 * 
 *       滑动谜题
 * 
 *       在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 *       一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 *       最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 *       给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 */
public class SlidingPuzzle773_ {

	/**
	 * 单向BFS
	 *
	 * @param board
	 * @return
	 */
	public int slidingPuzzle(int[][] board) {
		// 统计出现过的字符串
		Set<String> visited = new HashSet<>();
		// 定义一个队列来进行宽度优先遍历
		Queue<String[]> queue = new LinkedList<>();
		StringBuilder s = new StringBuilder();
		String targetStr = "123450";
		int index = 0; // 0出现的位置
		int step = 0; // 统计步数
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					index = i * 3 + j;
				}
				s.append(String.valueOf(board[i][j]));
			}
		}
		String boardStr = s.toString();
		if(boardStr.equals(targetStr)){
			return 0;
		}
		queue.add(new String[] { boardStr, index + "" });
		visited.add(boardStr);
		while (!queue.isEmpty()) {
			int size = queue.size();
			step++;
			for (int i = 0; i < size; i++) {
				String[] lastPattern = queue.poll();
				// 生成新的可能的字符串，进行判断
				for (String[] newStrs : genNewPattern(lastPattern[0], Integer.parseInt(lastPattern[1]))){
					// 排除掉已经出现过的字符串，只对新的字符串进行比较
					if(!visited.contains(newStrs[0])){
						if(newStrs[0].equals(targetStr)){
							return step;
						}else{
							visited.add(newStrs[0]);
							queue.add(newStrs);
						}
					}
				}
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param board
	 * @param visited
	 * @param index   0 所处的位置
	 * @return
	 */
	private List<String[]> genNewPattern(String board, int index) {
		int[] poss = {-1,1};
		char[] chars = board.toCharArray();
		List<String[]> res = new ArrayList<>();
		int row = index / 3;
		int col = index % 3;
		for(Integer pos : poss){
			row += pos;
			if(row >=0 && row <= 1){
				int preRow = row - pos;
				swap(chars, preRow * 3 + col, row * 3 + col);
				res.add(new String[]{new String(chars),String.valueOf(row * 3 + col)});
				swap(chars, preRow * 3 + col, row * 3 + col);	
			}
			row -= pos;
			col += pos;
			if(col >= 0 && col <= 2){
				int preCol = col - pos;
				swap(chars, row * 3 + preCol, row * 3 + col);
				res.add(new String[]{new String(chars),String.valueOf(row * 3 + col)});
				swap(chars, row * 3 + preCol, row * 3 + col);	
			}
			col -= pos;
		}
		return res;
	}

	private void swap(char[] chars,int prePos,int pos){
		char temp = chars[prePos];
		chars[prePos] = chars[pos];
		chars[pos] = temp;
	}

	public static void main(String[] args) {
		SlidingPuzzle773 s = new SlidingPuzzle773();
		int[][] board = new int[][]{{1,2,3},{5,4,0}};
		System.out.println(s.slidingPuzzle(board));
	}

}