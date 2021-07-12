package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-07-12 11:30:25
 * 
 *       H指数 II
 * 
 *       给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列 。
 * 
 *       编写一个方法，计算出研究者的 h 指数。
 * 
 *       h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的h指数是指他（她）的（N 篇论文中）总共有h
 *       篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 * 
 *       你可以优化你的算法到对数时间复杂度吗？
 * 
 */
public class HIndex275 {

	public int hIndex(int[] citations) {

		int l = 0, r = citations.length - 1;
		int s = citations.length;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (s - m == citations[m]) {
				return s - m;
			} else if (s - m < citations[m]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l >= s ? 0 : (r < 0 ? s : s - l);

	}


	public static void main(String[] args) {
		HIndex275 h = new HIndex275();
		System.out.println(h.hIndex(new int[]{100}));
	}

}