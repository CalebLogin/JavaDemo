package com.caleb.algorithm.offerdemo;

import java.util.HashSet;
import java.util.Set;

/**
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author：hanzhigang
 * @Date : 2021/3/16 10:06 PM
 */
public class OfferDemo57 {
    //  使用Hash
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (set.contains(target - num)) {
                return new int[]{num, target - num};
            } else {
                set.add(num);
            }
        }
        return new int[]{0, 0};
    }

    //  使用双指针
    public int[] twoSum1(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
//          如果找到符合条件的，跳出循环
            if ((target - nums[start]) == nums[end]) {
                break;
            } else if (target - nums[start] > nums[end]) {  // 如果两数之和小于target，start++
                start++;
            } else {    // 否则end--
                end--;
            }
        }
        return start != end ? new int[]{nums[start], nums[end]} : new int[]{0, 0};
    }
}
