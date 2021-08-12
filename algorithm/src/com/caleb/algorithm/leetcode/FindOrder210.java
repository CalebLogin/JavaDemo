package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:Caleb
 * @Date :2021-07-12 16:27:30
 * 
 *       课程表II
 * 
 *       现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 
 *       在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 
 *       给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 
 *       可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * 
 */
public class FindOrder210 {

	/**
	 * 广度优先遍历
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// 返回结果集
		int[] res = new int[numCourses];
		Queue<Integer> q = new LinkedList<>();
		// 存放每个节点的下游节点有哪些边
		List<List<Integer>> edges = new ArrayList<>();
		// 每个节点的入度
		int[] indeg = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<>());
		}
		for (int[] pre : prerequisites) {
			edges.get(pre[1]).add(pre[0]);
			++indeg[pre[0]];
		}
		for (int i = 0; i < numCourses; i++) {
			if (indeg[i] == 0) {
				q.offer(i);
			}
		}
		if(q.isEmpty()){
			return new int[0];
		}
		int visitedCount = 0;
		while (!q.isEmpty()) {
			if (visitedCount >= numCourses) {
				return new int[0];
			}
			int u = q.poll();
			for (int v : edges.get(u)) {
				--indeg[v];
				if (indeg[v] == 0) {
					q.offer(v);
				}
			}
			res[visitedCount] = u;
			++visitedCount;
		}
		return visitedCount == numCourses ?  res : new int[0];
	}

}