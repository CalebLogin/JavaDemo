package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-07-26 00:21:15
 * 
 *       从相邻元素对还原数组
 * 
 *       存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 * 
 *       给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi]
 *       表示元素 ui 和 vi 在 nums 中相邻。
 * 
 *       题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是
 *       [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 * 
 *       返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 *
 * 
 */
public class RestoreArray1743 {

	/**
	 * 双端队列
	 * 
	 * @param adjacentPairs
	 * @return
	 */
	public int[] restoreArray(int[][] adjacentPairs) {
		if (adjacentPairs.length == 1) {
			return adjacentPairs[0];
		}

		// 定义双端队列
		Deque<Integer> deque = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		for (int[] adjacentPair : adjacentPairs) {
			List<Integer> list1 = map.getOrDefault(adjacentPair[0], new ArrayList<>());
			list1.add(adjacentPair[1]);
			map.put(adjacentPair[0], list1);
			List<Integer> list2 = map.getOrDefault(adjacentPair[1], new ArrayList<>());
			list2.add(adjacentPair[0]);
			map.put(adjacentPair[1], list2);
		}
		System.out.println(map);
		int left = adjacentPairs[0][1], right = adjacentPairs[0][0];
		visited.add(left);
		visited.add(right);
		deque.add(left);
		deque.add(right);
		while(true){
			left = deque.peekFirst();
			List<Integer> list = map.get(left);
			left = list.get(0);
			if(!visited.contains(left)){
				deque.offerFirst(left);
				visited.add(left);
			}else if(list.size() > 1){
				left = list.get(1);
				if(!visited.contains(left)){
					deque.offerFirst(left);
					visited.add(left);
				}else{
					break;
				}
			}else{
				break;
			}
		}
		while(true){
			right = deque.peekLast();
			List<Integer> list = map.get(right);
			right = list.get(0);
			if(!visited.contains(right)){
				deque.offerLast(right);
				visited.add(right);
			}else if(list.size() > 1){
				right = list.get(1);
				if(!visited.contains(right)){
					deque.offerLast(right);
					visited.add(right);
				}else{
					break;
				}
			}else{
				break;
			}
		}
		int[] res = new int[adjacentPairs.length + 1];
		int pos = 0;
		while (!deque.isEmpty()) {
			res[pos++] = deque.poll();
		}
		return res;
	}

	public static void main(String[] args) {
		RestoreArray1743 r = new RestoreArray1743();
		int[] res = r.restoreArray(new int[][]{{2,1},{3,4},{3,2}});
		for(Integer i : res){
			System.out.print(i + " ");
		}
		System.out.println();
	}

}