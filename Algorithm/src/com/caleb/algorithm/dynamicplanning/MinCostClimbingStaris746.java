package com.caleb.algorithm.dynamicplanning;

/**
 * 使用最小花费爬楼梯
 *
 * @author：hanzhigang
 * @Date : 2021/3/23 9:07 PM
 */
public class MinCostClimbingStaris746 {
    public int minCostClimbingStairs(int[] cost) {

        int a = cost[0];
        int b = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = Math.min(b,a) + cost[i];
            a = b;
            b = temp;
        }
        return Math.min(a,b);
    }

    public static void main(String[] args) {
        MinCostClimbingStaris746 minCostClimbingStaris746 = new MinCostClimbingStaris746();
        System.out.println(minCostClimbingStaris746.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
