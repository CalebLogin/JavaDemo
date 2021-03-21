package com.eric.offerdemo;

/**
 * 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
<<<<<<< Updated upstream
 * 思路1：动态规划
 */
public class OfferDemo63 {
    public static int maxProfit(int[] prices) {
        int profit = 0; // 获取部分区间内的利润，当利润变为负值时，重置为0
        int maxProfit = 0;  // 在遍历过程中获得的最大利润
        int len = prices.length;    // 数组的长度
        for(int i=1;i<len;i++){
            // 今日与前一日的利润，如果之前利润加今日利润小于0，设置之前利润为0
            int left = prices[i] - prices[i-1];
            if(profit+left < 0){
                profit = 0;
            }else{
                profit+=left;
            }
            // 当利润存在最大值的时候，将该值记录下来
            if (maxProfit<profit){
                maxProfit = profit;
            }
        }
        // 返回结果
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] res = new int[]{7,6,5,3,2,1};
        System.out.println(maxProfit(res));
    }
=======
public class OfferDemo63 {
>>>>>>> Stashed changes
}
