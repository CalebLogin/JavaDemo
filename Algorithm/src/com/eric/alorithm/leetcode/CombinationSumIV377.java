package com.eric.alorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和IV
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 *
 * @author: hanzhigang
 * @Date : 2021/4/24 19:20
 */
public class CombinationSumIV377 {

    /**
     * 动态规划的思想
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {

        Arrays.sort(nums);
        // dp[i]表示计算到i有多少种组合
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (num <= i) {
                    // dp[i] 的最后一个数一定是小于i的
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV377 combinationSumIV377 = new CombinationSumIV377();
        System.out.println(combinationSumIV377.combinationSum4(new int[]{2, 1, 3}, 35));
    }
}
