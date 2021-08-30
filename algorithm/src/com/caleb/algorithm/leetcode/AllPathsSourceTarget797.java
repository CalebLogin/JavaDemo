package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-08-30 15:59:19
 * 
 *       所有可能的路径
 * 
 *       给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * 
 *       二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * 
 *       译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 */
public class AllPathsSourceTarget797 {
	List<Integer> list = new ArrayList<>();
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		traverse(0, graph);
		return res;
	}

	private void traverse(int num, int[][] graph) {
		if (num == graph.length - 1) {
			list.add(num);
			res.add(new ArrayList<>(list));
			list.remove(list.size() - 1);
			return;
		}
		list.add(num);
		for (int g : graph[num]) {
			traverse(g, graph);
		}
		list.remove(list.size() - 1);
	}
}