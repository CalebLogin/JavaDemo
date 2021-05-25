package com.caleb.alorithm.leetcode;

/**
 * 买卖股票的最佳时机II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * [7,1,5,3,6,4]
 *
 * @author：hanzhigang
 * @Date : 2021/4/17 11:48 PM
 */
public class MaxProfit122 {

    public int maxProfit(int[] prices) {
        int sum = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - prices[i - 1], 0);

            if(profit > 0){
                sum += profit;
            }
        }
        return sum;
    }

}
