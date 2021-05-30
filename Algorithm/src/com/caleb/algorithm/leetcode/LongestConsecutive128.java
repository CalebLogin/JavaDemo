package com.caleb.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 * @author：hanzhigang
 * @Date : 2021/4/19 8:35 PM
 */
public class LongestConsecutive128 {
    /**
     * 先排序后统计
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);  // 对数组进行排序
        int max = 1, count = 1;  // 记录最大值和当前数组中的连续值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
                max = Math.max(max, count);
            } else if (nums[i] - nums[i - 1] == 0) {
                continue;
            } else {
                count = 1;
            }
        }
        return max;
    }

    /**
     * 利用set
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxCount = 0;   // 记录最大长度
        int count = 0;  // 记录当前遍历过程中的长度

        Set<Integer> set = new HashSet<>(); // 将nums中的数值添加到set中
        for (int i : nums) {
            set.add(i);
        }

        for (Integer i : set) {
            if (!set.contains(i - 1)) { // 如果不存在i-1，也就是说不存在更优的长度，在这样的情况下，以i开头的连续路径最长，否则还存在更长的
                count = 0;
                int temp = i;
                while (set.contains(temp)) {
                    count++;
                    temp++;
                }
                maxCount = Math.max(maxCount,count);
            }
        }
        return maxCount;

    }
}
