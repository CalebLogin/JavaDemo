package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-08-05 17:00:54
 * 
 *       找到最终的安全状态
 * 
 *       在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * 
 *       对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * 
 *       返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * 
 *       该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j
 *       节点的一个列表，满足 (i, j) 是图的一条有向边。
 * 
 * 
 */
public class EventualSafeNodes802 {

	// 记录形成环路的节点
	boolean[] visited;

	/**
	 * 朴素算法，寻找环路 超时
	 * 
	 * @param graph
	 * @return
	 */
	public List<Integer> eventualSafeNodes(int[][] graph) {
		int m = graph.length;
		// 记录当前节点是否被访问过
		visited = new boolean[m];
		List<Integer> res = new ArrayList<>();
		// 进行深度优先遍历
		for (int i = 0; i < m; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (dfs(i, graph)) {
					visited[i] = false;
					res.add(i);
				}
			}
		}
		return res;
	}

	private boolean dfs(int start, int[][] graph) {
		int[] nodes = graph[start];
		for (int i = 0; i < nodes.length; i++) {
			// 如果当前节点已经被访问过了说明存在环路。已经遍历的所有节点的visited全部置为true
			if (visited[nodes[i]]) {
				return false;
			} else {
				visited[nodes[i]] = true;
				if (dfs(nodes[i], graph)) {
					visited[nodes[i]] = false;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 三色标记法
	 * 
	 * @param graph
	 * @return
	 */
	public List<Integer> eventualSafeNodes1(int[][] graph) {
		int m = graph.length;
		List<Integer> res = new ArrayList<>();
		// 初始化为0，访问中为1，访问过为2
		int[] color = new int[m];
		for (int i = 0; i < m; i++) {
			if (dfs1(graph, color, i)) {
				res.add(i);
			}
		}
		return res;
	}

	private boolean dfs1(int[][] graph, int[] color, int start) {
		if (color[start] != 0) {
			return color[start] == 2;
		}
		color[start] = 1;
		for (Integer y : graph[start]) {
			if (!dfs1(graph, color, y)) {
				return false;
			}
		}
		color[start] = 2;
		return true;
	}

	public static void main(String[] args) {
		EventualSafeNodes802 eventualSafeNodes802 = new EventualSafeNodes802();
		System.out.println(eventualSafeNodes802
				.eventualSafeNodes1(new int[][] { { 1, 2, 3, 4 }, { 1, 2 }, { 3, 4 }, { 0, 4 }, {} }).toString());
	}

}