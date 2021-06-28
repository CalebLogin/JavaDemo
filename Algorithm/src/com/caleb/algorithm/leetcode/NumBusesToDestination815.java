package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-06-28 09:22:13
 * 
 *       公交路线
 * 
 *       给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 *       例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7
 *       -> 1 -> ... 这样的车站路线行驶。 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。
 *       期间仅可乘坐公交车。 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * 
 */
public class NumBusesToDestination815 {

	/**
	 * 广度优先遍历
	 * 单向队列
	 * @param routes
	 * @param source
	 * @param target
	 * @return
	 */
	public int numBusesToDestination(int[][] routes, int source, int target) {
		if(source == target){
			return 0;
		}
		// 最小乘坐的公交车数量
		int step = 1;
		// 目的地对应的公交线路，可能该站点对应多条路线，用集合存放
		Set<Integer> targetLine = new HashSet<>();
		int row = routes.length;
		// 每个站点对应的所有路线
		Map<Integer, List<Integer>> stationsLines = new HashMap<>();
		// 当前路线是否被访问过
		boolean[] visited = new boolean[row];
		for (int i = 0; i < row; i++) {
			int col = routes[i].length;
			for (int j = 0; j < col; j++) {
				if (routes[i][j] == target) {
					targetLine.add(i);
				}
				List<Integer> list = stationsLines.getOrDefault(routes[i][j], new ArrayList<>());
				stationsLines.put(routes[i][j], list);
				list.add(i);
			}
		}

		// 访问过的路线
		Queue<Integer> d = new LinkedList<>();
		for (Integer line : stationsLines.get(source)) {
			if (targetLine.contains(line)) {
				return step;
			} else {
				d.add(line);
			}
			visited[line] = true;
		}
		while (!d.isEmpty()) {
			int size = d.size();
			step++;
			for (int i = 0; i < size; i++) {
				int currLine = d.poll();
				for (Integer station : routes[currLine]) {
					// 每个站点对应的全部路线
					List<Integer> lines = stationsLines.get(station);
					for (Integer line : lines) {
						// 如果当前路线还没有乘坐过，加入队列中
						if (!visited[line]) {
							if (targetLine.contains(line)) {
								return step;
							}
							d.offer(line);
							visited[line] = true;
						}
					}
				}
			}
		}
		return -1;
	}
	
	public int numBusesToDestination1(int[][] routes, int source, int target) {
		return 0;
	}

	public static void main(String[] args) {
		int[][] routes = new int[][] { { 16, 25, 29, 35, 42 }, { 32 }, { 1 }, { 1, 2, 5, 17, 22, 34, 38, 41, 44 },
				{ 1, 16, 23, 24, 32, 36, 38, 45 }, { 9, 11, 43 }, { 5, 10, 15, 22, 27, 38 },
				{ 7, 8, 14, 19, 22, 23, 25, 26, 27 }, { 3, 8, 24, 29, 47, 48 }, { 4, 16, 18, 25, 36, 41 } };
		NumBusesToDestination815 n = new NumBusesToDestination815();
		System.out.println(n.numBusesToDestination(routes, 17, 38));
	}

}