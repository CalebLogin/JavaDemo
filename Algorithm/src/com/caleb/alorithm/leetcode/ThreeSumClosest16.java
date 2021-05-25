package com.caleb.alorithm.leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * @author：hanzhigang
 * @Date : 2021/4/4 4:55 PM
 */
public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);  // 对数组排序
        int minSubValue = Integer.MAX_VALUE;    // 与目标函数的最小差值
        int res = 0;    // 最接近三数之和的结果
        int left, right; // 遍历nums数组的左右指针

        for (int i = 0; i < nums.length - 2; i++) {

            // 如果之前遍历过，继续下一遍
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (minSubValue > Math.abs(target - temp)) {
                    res = temp;
                    minSubValue = Math.abs(target - temp);
                }
                if (target < temp) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (target > temp) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    return target;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        ThreeSumClosest16 threeSumClosest16 = new ThreeSumClosest16();
        System.out.println(threeSumClosest16.threeSumClosest(new int[]{1, 1, 1, 1}, 0));
    }
}
