package com.caleb.algorithm.offerdemo;

/**
 * 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * @author：hanzhigang
 * @Date : 2021/3/17 9:54 PM
 */
public class OfferDemo59_I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0){
            return new int[0];
        }
        int[] dp = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            // 如果当前滑动窗口处于初始位置，对范围内的数组进行找最大值操作
            if (i - k < 0) {
                dp[i - k + 1] = maxNum(nums, 0, i);
            } else {
                // 如果上一个滑动窗口的最大值在现在滑动窗口的范围内，比较最大值与当前值，记录最大值的下标
                if (dp[i - k] > i - k) {
                    dp[i - k + 1] = nums[dp[i - k]] > nums[i] ? dp[i - k] : i;
                } else {    // 上一个滑动窗口的最大值已经滑出现在滑动窗口的范围，重新计算最大值的下标
                    dp[i - k + 1] = maxNum(nums, i - k + 1, i);
                }
            }
        }
        // 将下标对应的值替换下标
        for (int i = 0; i < dp.length; i++) {
            dp[i] = nums[dp[i]];
        }
        return dp;
    }

    public int maxNum(int[] nums, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }
}
