package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-07-11 10:38:27
 * 
 *       H指数
 * 
 *       给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * 
 *       h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h
 *       篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。
 * 
 *       例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 * 
 */
public class HIndex274 {

	/**
	 * 排序
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		for (int j = 0; j < citations.length; j++) {
			if (citations.length - j <= citations[j]) {
				return citations.length - j;
			}
		}
		return 0;
	}

	/**
	 * 计数排序
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndex1(int[] citations) {
		Arrays.sort(citations);
		int n = citations.length;
		int[] counts = new int[n + 1];
		for (int i = 0; i < n; i++) {
			int top = citations[i] <= n ? citations[i] : n;
			counts[top]++;
		}
		int tot = 0;
		for (int i = n+1; i >=0; i--) {
			tot += counts[i];
			if(i <= tot){
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		HIndex274 h = new HIndex274();
		System.out.println(h.hIndex(new int[] { 3, 0, 6, 1, 5 }));
	}

}