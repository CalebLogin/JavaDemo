package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-09-17 23:08:59
 * 
 *       插入区间
 * 
 *       给你一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 *       在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 *       0 <= intervals.length <= 10^4
 * 
 *       intervals[i].length == 2
 * 
 *       0 <= intervals[i][0] <= intervals[i][1] <= 10^5
 * 
 *       intervals 根据 intervals[i][0] 按 升序 排列 newInterval.length == 2
 * 
 *       0 <= newInterval[0] <= newInterval[1] <= 10^5
 * 
 */
public class Insert57 {

	/**
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public int[][] insert(int[][] intervals, int[] newInterval) {

		int newStart = newInterval[0];
		int newEnd = newInterval[1];
		List<int[]> res = new ArrayList<>();
		for(int[] is : intervals){
			int currStart = is[0];
			int currEnd = is[1];
			if(currStart > newEnd){
				res.add(new int[]{newStart,newEnd});
				newStart = currStart;
				newEnd = currEnd;
			}else if(currEnd < newStart){
				res.add(new int[]{currStart,currEnd});
			}else if((newStart >= currStart && newEnd <= currEnd) 
						|| (newStart <= currStart && newEnd >= currEnd)){
				newStart = Math.min(newStart, currStart);
				newEnd = Math.max(newEnd, currEnd);	
			}else if((newStart >= currStart && newStart <= currEnd && newEnd >= currEnd) 
						|| (newStart <= currEnd && newEnd >= currStart && newEnd <= currEnd)){
				newStart = Math.min(newStart, currStart);
				newEnd = Math.max(newEnd, currEnd);	
			}
		}
		if(res.isEmpty() || newStart > res.get(res.size()-1)[1]){
			res.add(new int[]{newStart,newEnd});	
		}
		return res.toArray(new int[0][0]);
	}

}