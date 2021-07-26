package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-07-26 09:18:14
 * 
 *       得到子序列的最小操作次数
 * 
 *       给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。
 * 
 *       每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加
 *       3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。
 * 
 *       请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。
 * 
 *       一个数组的
 *       子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。
 * 
 *       输入：target = [5,1,3], arr = [9,4,2,3,4] 输出：2 解释：你可以添加 5 和 1 ，使得 arr 变为
 *       [5,9,4,1,2,3,4] ，target 为 arr 的子序列。
 * 
 */
public class MinOperations1713 {

	/**
	 * 统计前缀和
	 * 
	 * 超时
	 * 
	 * @param target
	 * @param arr
	 * @return
	 */
	public int minOperations(int[] target, int[] arr) {

		// 统计最大前缀
		int maxRes = 0;
		Map<Integer, Integer> numToPos = new HashMap<>();
		int[] numToPrefix = new int[target.length];
		for (int i = 0; i < target.length; i++) {
			numToPos.put(target[i], i);
		}
		for (int i = 0; i < arr.length; i++) {
			if (numToPos.containsKey(arr[i])) {
				int pos = numToPos.get(arr[i]);
				int currPrefix = 0;
				// 寻找当前位置之前最大的前缀和
				for (int j = pos - 1; j >= 0; j--) {
					currPrefix = Math.max(currPrefix, numToPrefix[j]);
				}
				numToPrefix[pos] = currPrefix + 1;
				maxRes = Math.max(numToPrefix[pos], maxRes);
			}
		}

		return target.length - maxRes;
	}

	/**
	 * 最长递增子序列解法
	 * 
	 * 贪心 + 二分查找
	 * 
	 * @param target
	 * @param arr
	 * @return
	 */
	public int minOperations1(int[] target, int[] arr) {

		int len = target.length;
		// 记录当前位置最长递增子序列的数字
		int[] tail = new int[len];
		// 当前最长递增子序列的长度
		int maxRes = 0;
		// 将目标数组中的数字映射到对应下标
		Map<Integer, Integer> quickFindTarget = new HashMap<>();
		for (int i = 0; i < len; i++) {
			quickFindTarget.put(target[i], i);
		}
		// 将在目标数组中的数字映射到对应下标
		List<Integer> existsInTarget = new ArrayList<>();
		for (Integer num : arr) {
			if (quickFindTarget.containsKey(num)) {
				existsInTarget.add(quickFindTarget.get(num));
			}
		}
		for (int i = 0; i < existsInTarget.size(); i++) {
			int l = 0, r = maxRes;
			int num = existsInTarget.get(i);
			while (l < r) {
				int mid = l + (r - l) / 2;
				if (tail[mid] < num) {
					l = mid + 1;
				} else {
					r = mid;
				}
			}
			tail[l] = num;
			if (r == maxRes) {
				maxRes++;
			}
		}

		return target.length - maxRes;

	}

	public static void main(String[] args) {
		MinOperations1713 m = new MinOperations1713();
		int[] target = { 1, 5, 3 };
		int[] arr = { 9, 4, 2, 3, 4 };
		System.out.println(m.minOperations1(target, arr));
	}

}