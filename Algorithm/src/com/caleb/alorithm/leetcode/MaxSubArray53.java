package com.caleb.alorithm.leetcode;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author：hanzhigang
 * @Date : 2021/3/25 10:47 PM
 */
public class MaxSubArray53 {

    /**
     * 使用动态规划的思想
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {


        int maxSum = Integer.MIN_VALUE; // 定义最大返回值
        int curSum = 0; // 记录当前值
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;

    }
}
