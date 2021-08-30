package com.caleb.algorithm.review;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author:Caleb
 * @Date :2021-08-30 16:05:42
 */
public class CanFinish207 {

	/**
	 * 邻接表 + 入度表
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> numToNodes = new HashMap<>();
		int[] ineq = new int[numCourses];
		int alreadyCourses = 0;
		for (int i = 0; i < numCourses; i++) {
			numToNodes.put(i, new ArrayList<>());
		}
		Queue<Integer> q = new ArrayDeque<>();
		for (int[] prerequisite : prerequisites) {
			List<Integer> list = numToNodes.get(prerequisite[1]);
			list.add(prerequisite[0]);
			numToNodes.put(prerequisite[1], list);
			++ineq[prerequisite[0]];
		}

		for (int i = 0; i < numCourses; i++) {
			if (ineq[i] == 0) {
				alreadyCourses++;
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int courseNum = q.poll();
			for (Integer course : numToNodes.get(courseNum)) {
				if (--ineq[course] == 0) {
					alreadyCourses++;
					q.offer(course);
				}
			}
		}
		return alreadyCourses == numCourses;

	}

}