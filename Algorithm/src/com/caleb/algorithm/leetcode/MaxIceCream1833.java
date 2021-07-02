package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-07-02 09:18:53
 * 
 *       雪糕的最大数量
 * 
 *       夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中
 *       costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。 给你价格数组
 *       costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。注意：Tony
 *       可以按任意顺序购买雪糕。
 * 
 */
public class MaxIceCream1833 {

	/**
	 * 贪心
	 * 
	 * @param costs
	 * @param coins
	 * @return
	 */
	public int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		int count = 0;
		for(int i = 0;i<costs.length;i++){
			if(coins <= costs[i]){
				count++;
				coins -= costs[i];
			}else{
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		MaxIceCream1833 m = new MaxIceCream1833();
		m.maxIceCream(new int[] { 1, 6, 3, 1, 2, 5 }, 20);
	}
}