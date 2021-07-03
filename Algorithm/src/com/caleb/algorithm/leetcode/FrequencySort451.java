package com.caleb.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * @author:Caleb
 * @Date :2021-07-03 09:29:07
 * 
 *       根据字符串出现频率排序
 * 
 *       给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 
 */
public class FrequencySort451 {

	/**
	 * 优先队列
	 * @param s
	 * @return
	 */
	public String frequencySort(String s) {
		char[] sChars = s.toCharArray();
		PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
		int[] cCounts = new int[128];
		// 统计每个字符出现的次数
		for (Character c : sChars) {
			cCounts[c]++;
		}
		// 放入优先队列进行排序
		for (int i = 0; i < cCounts.length; i++) {
			if (cCounts[i] != 0) {
				p.offer(new int[] { i, cCounts[i] });
			}
		}
		int index = 0;
		while (!p.isEmpty()) {
			int[] temp = p.poll();
			while (temp[1] != 0) {
				sChars[index] = (char) temp[0];
				temp[1]--;
				index++;
			}
		}
		return new String(sChars);

	}

	public static void main(String[] args) {
		FrequencySort451 f = new FrequencySort451();
		System.out.println(f.frequencySort("tree"));
	}

}
