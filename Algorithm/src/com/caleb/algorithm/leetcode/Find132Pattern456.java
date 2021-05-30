package com.caleb.algorithm.leetcode;

import java.util.LinkedList;

/**
 * 132模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。
 * 132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 * 思路1：单调栈
 * 思路2：树状数组
 *
 * @author：hanzhigang
 * @Date : 2021/3/24 9:07 PM
 */
public class Find132Pattern456 {
    public boolean find132pattern(int[] nums) {
        // 维护一个单调递减栈
        LinkedList<Integer> stack = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peekLast() < nums[i]) {
                    max = max < stack.peekLast() ? stack.peekLast() : max;
                    stack.removeLast();
                } else {
                    break;
                }
            }
            stack.addLast(nums[i]);
            if (stack.size() >= 2 && nums[i] < max) {
                return true;
            }


        }
        return false;
    }
}
