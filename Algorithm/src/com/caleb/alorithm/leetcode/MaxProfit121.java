package com.caleb.alorithm.leetcode;

/**
 * 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 6:47 PM
 */
public class MaxProfit121 {

    /**
     * 动态规划的思想
     * 记录最大利润，如果当前的利润加上今天与昨天的差值小于0的话，则当前的利润置为0
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 当前的最大利润
        int maxPro = 0;
        // 记录每一天能得到的最大利润
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // 利润取之前的利润加上今天的差值和0的最大值
            profit = Math.max(profit + prices[i] - prices[i-1], 0);
            if(profit > maxPro){
                maxPro = profit;
            }
        }
        return maxPro;

    }
}
