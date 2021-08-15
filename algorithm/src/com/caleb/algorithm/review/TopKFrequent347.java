package com.caleb.algorithm.review;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author:Caleb
 * @Date :2021-08-15 16:30:00
 */
public class TopKFrequent347 {

	public int[] topKFrequent(int[] nums, int k) {
		int[] res = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}

		});
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			p.offer(new int[] { entry.getKey(), entry.getValue() });
		}
		for (int i = 0; i < k; i++) {
			res[i] = p.poll()[0];
		}
		return res;
	}

}