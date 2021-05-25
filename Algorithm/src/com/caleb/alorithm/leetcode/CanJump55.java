package com.caleb.alorithm.leetcode;

/**
 * 跳跃问题
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 思路：统计0出现的位置，只要能够越过0的位置就能到达最后一个下标
 *
 * @author：hanzhigang
 * @Date : 2021/4/9 11:03 AM
 */
public class CanJump55 {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int maxRight = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxRight < i) {
                return false;
            }
            maxRight = Math.max(nums[i] + i, maxRight);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] res = new int[]{0};
        System.out.println(canJump(res));
    }
}
