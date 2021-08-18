package com.caleb.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:Caleb
 * @Date :2021-08-18 15:11:42
 * 
 *       无重叠区间
 * 
 *       给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 
 */
public class EraseOverlapIntervals435 {

	/**
	 * 贪心算法
	 * 
	 * @param intervals
	 * @return
	 */
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[1] - o2[1];
			}

		});
		int x_end = intervals[0][1];
		int count = 1;
		for (int[] interval : intervals) {
			if (interval[0] >= x_end) {
				count++;
				x_end = interval[1];
			}
		}
		return intervals.length - count;
	}
}