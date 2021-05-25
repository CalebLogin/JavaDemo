package com.caleb.alorithm.leetcode;

/**
 * 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @Date : 2021/4/5 8:00 PM
 */
public class RemoveDuplicates26 {
    /**
     * 双指针，一个指针用来遍历，一个指针用来记录当前没有重复的数组的下标
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int curIndex = 0;
        int index = 0;
        for (; curIndex < nums.length; curIndex++) {
            if (nums[curIndex] != nums[index]) {
                nums[++index] = nums[curIndex];
            }
        }
        return index+1 ;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,2,2,2,3,328,4};
        RemoveDuplicates26 removeDuplicates26 = new RemoveDuplicates26();
        System.out.println(removeDuplicates26.removeDuplicates(nums));
    }
}
