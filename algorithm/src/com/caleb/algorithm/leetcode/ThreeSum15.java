package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 思路1：采用排序加双指针来解决
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 7:07 PM
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 双指针
        int left, right;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > 0) return res;

            // 如果之前对此值进行过遍历，不再进行
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            left = i + 1;
            right = nums.length - 1;
            while (left < nums.length && left < right) {
                // 如果三数值和符合条件，加入list。
                // 若是比0小，说明left不够大，left++，否则right--；
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    while (right > left && nums[right + 1] == nums[right]) {
                        right--;
                    }
                } else if (temp > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;

    }
}
