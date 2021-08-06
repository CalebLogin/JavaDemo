package com.caleb.algorithm.review.offerdemo;

/**
 * @author:Caleb
 * @Date :2021-08-06 16:44:47
 */
public class MaxProfit63 {

	public int maxProfit(int[] prices) {
		int maxPro = 0;
		int currPro = 0;
		for (int i = 1; i < prices.length; i++) {
			int pro = prices[i] - prices[i - 1];
			if (pro + currPro >= 0) {
				currPro += pro;
			} else {
				currPro = 0;
			}
			maxPro = Math.max(maxPro, currPro);
		}
		return maxPro;
	}

}