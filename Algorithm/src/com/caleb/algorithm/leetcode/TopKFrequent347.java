package com.caleb.algorithm.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author:Caleb
 * @Date :2021-06-19 15:00:12
 */
public class TopKFrequent347 {

	/**
	 * 定义哈希表
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] topKFrequent(int[] nums, int k) {
		int[] res = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int maxIndex = 0;
		int maxV = 0;
		for (int i = 0; i < k; i++) {
			for (Map.Entry<Integer, Integer> kEntry : map.entrySet()) {
				if (kEntry.getValue() > maxV) {
					maxIndex = kEntry.getKey();
					maxV = kEntry.getValue();
				}
			}
			res[i] = maxIndex;
			map.remove(maxIndex);
			maxV = 0;
		}
		return res;
	}

	public int[] topKFrequent1(int[] nums, int k) {
		int[] res = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});

		for (Map.Entry<Integer, Integer> kEntry : map.entrySet()) {
			System.out.println(kEntry.getKey() + " " + kEntry.getValue());
			if (p.size() == k ){
				if(p.peek()[1] < kEntry.getValue()) {
					p.poll();
					p.offer(new int[] { kEntry.getKey(), kEntry.getValue() });
				}
			}else{
				p.offer(new int[] { kEntry.getKey(), kEntry.getValue() });
			}
			
		}
		for (int i = 0; i < k; i++) {
			res[i] = p.poll()[0];
		}
		return res;

	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		TopKFrequent347 topKFrequent347 = new TopKFrequent347();
		int[] res = topKFrequent347.topKFrequent1(nums, 2);
		for (Integer i : res) {
			System.out.println(i);
		}
	}

}