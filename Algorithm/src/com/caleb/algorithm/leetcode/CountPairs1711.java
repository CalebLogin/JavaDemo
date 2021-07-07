package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-07-07 10:48:06
 * 
 *       大餐计数
 * 
 *       大餐是指恰好包含两道不同餐品的一餐，其美味程度之和等于2的幂。 你可以搭配任意两道餐品做一顿大餐。
 * 
 *       给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​
 *       道餐品的美味程度，返回你可以用数组中的餐品做出的不同大餐的数量。结果需要对 109 + 7 取余。
 * 
 *       注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 */
public class CountPairs1711 {

	/**
	 * 暴力
	 * 
	 * 超时
	 * 
	 * @param deliciousness
	 * @return
	 */
	public int countPairs(int[] deliciousness) {
		int resCount = 0;
		for (int i = 0; i < deliciousness.length; i++) {
			for (int j = i + 1; j < deliciousness.length; j++) {
				int del = deliciousness[i] + deliciousness[j];
				// 当两数之和大于1并且二进制位数只有1时，符合条件
				resCount += Integer.bitCount(del) == 1 ? 1 : 0;
				resCount %= (Math.pow(10, 9) + 7);
			}
		}
		return resCount;
	}

	/**
	 * 哈希
	 * 
	 * @param deliciousness
	 * @return
	 */
	public int countPairs1(int[] deliciousness) {
		int resCount = 0;
		int maxNum = 0;
		final int MOD = 1000000007;
		Map<Integer, Integer> map = new HashMap<>();
		int len = deliciousness.length;
		for (int i = 0; i < len; i++) {
			maxNum = Math.max(maxNum, deliciousness[i]);
		}
		maxNum *= 2;
		for (int i = 0; i < len; i++) {
			int val = deliciousness[i];
			// 遍历每一个2的幂数去寻找减去当前的数，差为数组中的数
			for (int num = 1; num < maxNum; num <<= 1) {
				int count = map.getOrDefault(num - val, 0);
				resCount = (resCount + count) % MOD;
			}
			map.put(val, map.getOrDefault(val, 0) + 1);
		}
		return resCount;
	}

	/**
	 * 按照2的幂数
	 * 
	 * @param deliciousness
	 * @return
	 */
	public int countPairs2(int[] deliciousness) {
		long resCount = 0;
		int maxNum = 0;
		final int MOD = 1000000007;
		Map<Integer, Long> map = new HashMap<>();
		for (Integer i : deliciousness) {
			map.put(i, map.getOrDefault(i, 0L) + 1);
			maxNum = Math.max(maxNum, i);
		}
		maxNum *= 2;
		List<Integer> onlyDeliciousness = new ArrayList<>(map.keySet());
		onlyDeliciousness.sort((o1, o2) -> (o1 - o2));
		for (int num = 1; num <= maxNum; num <<= 1) {
			int left = 0, right = onlyDeliciousness.size() - 1;
			while (left <= right) {
				int leftNum = onlyDeliciousness.get(left);
				int rightNum = onlyDeliciousness.get(right);
				if (leftNum + rightNum == num) {
					if (leftNum != rightNum) {
						resCount += map.get(leftNum) * map.get(rightNum);
					} else {
						resCount += map.get(leftNum) * (map.get(leftNum) - 1) / 2;
					}
					resCount %= MOD;
					left++;
				} else if (leftNum + rightNum > num) {
					right--;
				} else {
					left++;
				}
			}
		}
		return (int) resCount;
	}

	/**
	 * 100%的解法
	 * 
	 * @param deliciousness
	 * @return
	 */
	public int countPairs3(int[] deliciousness) {
		int min, max;
		max = min = deliciousness[0];
		for (int v : deliciousness) {
			if (min > v) {
				min = v;
			} else if (max < v) {
				max = v;
			}
		}
		int[] map = new int[max - min + 1];
		long res = 0;
		for (int v : deliciousness) {
			for (int s = 1;; s <<= 1) {
				int x = s - v;
				if (x < min) {
					continue;
				}
				if (x > max) {
					break;
				}
				res += map[x - min];
			}
			map[v - min]++;
		}
		return (int) (res % 1_000_000_007L);
	}

	public static void main(String[] args) {
		CountPairs1711 c = new CountPairs1711();
		System.out.println(c.countPairs2(new int[] { 1, 1, 1, 1 }));
	}

}