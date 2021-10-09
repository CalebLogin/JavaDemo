package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-09-30 22:05:43
 * 
 *       最大相等频率
 * 
 *       给出一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回其长度：
 * 
 *       从前缀中 删除一个 元素后，使得所剩下的每个数字的出现次数相同。
 *       如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 * 
 *       [2,2,1,1,5,3,3,5,5]
 * 
 *       最大频率，最小频率，和最大频率相等出现的元素数，和最小频率相等出现的元素数 1 0 1 0 , 2 0 1 0 , 2 1 1 1 , 2 0
 *       2 0 , 2 1 2 1 , 2 1 2 2 , 2 1 3 1, 2 0 4 0 , 3 2 1 3
 */
public class MaxEqualFreq1224 {

	public int maxEqualFreq(int[] nums) {
		int maxV = Integer.MIN_VALUE;
		int n = nums.length;
		// 表示频率
		int[] freqArr = new int[100000];
		Set<Integer> set = new HashSet<>();
		int currMaxFreq;
		int currMinFreq;
		for (int i = 0; i < n; i++) {
			freqArr[nums[i]]++;
			int freq1 = 0, freq2 = 0;
			int nums1 = 0, nums2 = 0;
			boolean flag = true;
			for (int j = 0; j <= 100000; j++) {
				if (freqArr[j] != 0) {
					if (freq1 == 0) {
						freq1 = freqArr[j];
						nums1++;
					} else if (freqArr[j] == freq1) {
						nums1++;
					} else if (freq2 == 0) {
						freq2 = freqArr[j];
						nums2++;
					} else if (freqArr[j] == freq2) {
						nums2++;
					} else {
						flag = false;
						break;
					}
				}
				if (flag) {
					// TODO
				}
			}
		}
		// TODO
		return 0;
	}

	public static int maxEqualFreq1(int[] nums) {
		if (nums.length == 1 || nums.length == 0) {
			return nums.length;
		}
		int maxLen = Integer.MIN_VALUE;
		int maxFreq = Integer.MIN_VALUE;
		int minFreq = Integer.MAX_VALUE;
		// 频率对应元素个数
		Map<Integer, Integer> freq = new HashMap<>();
		// 元素对应出现的频率
		Map<Integer, Integer> numsMap = new HashMap<>();
		for (Integer i : nums) {
			Integer numsFreq = numsMap.getOrDefault(i, 0) + 1;
			numsMap.put(i, numsFreq);
			maxFreq = Math.max(numsFreq, maxFreq);
			minFreq = Math.min(minFreq, numsFreq);
			if (freq.containsKey(numsFreq - 1)) {
				int preNumsFreq = freq.get(numsFreq - 1);
				if (preNumsFreq == 1) {
					if (minFreq == numsFreq - 1) {
						minFreq = freq.getOrDefault(numsFreq, 0) + 1;
					}
					freq.remove(numsFreq - 1);
				} else {
					freq.put(numsFreq - 1, preNumsFreq - 1);
				}
			}
			freq.put(numsFreq, freq.getOrDefault(numsFreq, 0) + 1);
			if (freq.size() == 2) {
				// 最大频率出现次数
				int maxFreqCount = freq.get(maxFreq);
				int minFreqCount = freq.get(minFreq);
				if ((minFreq == 1 && minFreqCount == 1) || (maxFreqCount == 1 && (maxFreq - minFreq == 1))) {
					maxLen = Math.max(maxFreqCount * maxFreq + minFreqCount * minFreq, maxLen);
				}
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(maxEqualFreq1(new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5 }));
	}

}