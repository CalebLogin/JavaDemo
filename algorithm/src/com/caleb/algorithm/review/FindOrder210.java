package com.caleb.algorithm.review;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author:Caleb
 * @Date :2021-08-30 16:06:43
 */
public class FindOrder210 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		Map<Integer, List<Integer>> numToNodes = new HashMap<>();
		int[] ineq = new int[numCourses];
		int alreadyCourses = 0;
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++) {
			numToNodes.put(i, new ArrayList<>());
		}
		for (int[] prerequisite : prerequisites) {
			List<Integer> list = numToNodes.get(prerequisite[1]);
			list.add(prerequisite[0]);
			numToNodes.put(prerequisite[1], list);
			ineq[prerequisite[0]]++;
		}
		int index = 0;
		for (int i = 0; i < numCourses; i++) {
			if (ineq[i] == 0) {
				q.offer(i);
				alreadyCourses++;
				res[index++] = i;
			}
		}
		while (!q.isEmpty()) {
			int currNode = q.poll();
			for (Integer i : numToNodes.get(currNode)) {
				if (--ineq[i] == 0) {
					alreadyCourses++;
					q.add(i);
					res[index++] = i;
				}
			}
		}

		return numCourses == alreadyCourses ? res : new int[0];
	}

}