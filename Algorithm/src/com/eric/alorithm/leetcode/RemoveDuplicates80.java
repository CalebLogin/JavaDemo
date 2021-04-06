package com.eric.alorithm.leetcode;

/**
 * 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author：hanzhigang
 * @Date : 2021/4/6 7:30 PM
 */
public class RemoveDuplicates80 {
    public int removeDuplicates(int[] nums) {

        if(nums.length <= 1){
            return nums.length;
        }

        int curIndex = 0;
        int count = 1;  // 超过2则不计入
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[curIndex]){
                count = 1;
                nums[++curIndex] = nums[i];
            }else if(nums[i] == nums[curIndex]){
                if(count<2){
                    nums[++curIndex] = nums[i];
                    count++;
                }
            }
        }
        return curIndex+1;
    }

    public static void main(String[] args) {
        RemoveDuplicates80 removeDuplicates80 = new RemoveDuplicates80();
        System.out.println(removeDuplicates80.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
