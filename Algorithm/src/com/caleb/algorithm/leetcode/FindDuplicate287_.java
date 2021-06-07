package com.caleb.algorithm.leetcode;

/**
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间
 *
 * @author：hanzhigang
 * @Date : 2021/6/7 12:30 AM
 */
public class FindDuplicate287_ {
    /**
     * 原地置换的思想
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindDuplicate287_ findDuplicate287 = new FindDuplicate287_();
        System.out.println(findDuplicate287.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
