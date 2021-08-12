package com.caleb.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:Caleb
 * @Date :2021-08-06 15:45:20
 * 
 *       访问所有节点的最短路径
 * 
 *       存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
 * 
 *       给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
 * 
 *       返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 * 
 */
public class shortestPathLength847 {

	/**
	 * BFS + 状态压缩
	 * 
	 * @param graph
	 * @return
	 */
	public int shortestPathLength(int[][] graph) {
		int n = graph.length;
		int mask = 1 << n;
		// 记录通过该节点达到该状态值的步数
		int[][] dist = new int[mask][n];
		for (int i = 0; i < mask; i++) {
			Arrays.fill(dist[i], Integer.MIN_VALUE);
		}
		// BFS
		Queue<int[]> queue = new LinkedList<>();
		for (int node = 0; node < n; node++) {
			dist[1 << node][node] = 0;
			// 向队列中加入状态值和节点
			queue.offer(new int[] { 1 << node, node });
		}
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int state = poll[0];
			int node = poll[1];
			int step = dist[state][node];
			if (state == mask - 1) {
				return step;
			}
			for (int i : graph[node]) {
				if (dist[state | (1 << i)][i] == Integer.MIN_VALUE) {
					dist[state | (1 << i)][i] = step + 1;
					queue.offer(new int[] { state | (1 << i), i });
				}
			}
		}
		return -1;
	}

}