package com.caleb.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:Caleb
 * @Date :2021-08-18 16:09:37
 * 
 *       视频拼接
 * 
 *       你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 * 
 *       视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。
 * 
 *       我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * 
 *       我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0,
 *       T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 * 
 * 
 */
public class VideoStitching1024 {

	public int videoStitching(int[][] clips, int time) {
		// 按开始坐标升序排序，如果相同按结束坐标降序排序
		Arrays.sort(clips, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		if (clips[0][0] != 0) {
			return -1;
		}
		int count = 0;
		int currEnd = 0, nextEnd = 0;
		int i = 0, n = clips.length;
		while (i < n && clips[i][0] <= currEnd) {
			while (i < n && clips[i][0] <= currEnd) {
				nextEnd = Math.max(nextEnd, clips[i][1]);
				i++;
			}
			count++;
			currEnd = nextEnd;
			if (currEnd >= time) {
				return count;
			}
		}
		return -1;

	}
}