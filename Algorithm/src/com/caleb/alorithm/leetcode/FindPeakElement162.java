package com.caleb.alorithm.leetcode;

/**
 * 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * @author：hanzhigang
 * @Date : 2021/5/7 10:29 PM
 */
public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        int[] res = new int[nums.length+2];
        res[0] = Integer.MIN_VALUE;
        res[res.length-1] = Integer.MIN_VALUE;
        System.arraycopy(nums,0,res,1,nums.length);
        for(int i = 1;i<res.length-1;i++){
            if(res[i-1] < res[i] && res[i+1] < res[i]){
                return i-1;
            }
        }
        return 0;
    }

    public int findPeakElement1(int[] nums){
        return findPeakElementHelper(nums, 0, nums.length-1);
    }

    public int findPeakElementHelper(int[] nums, int l, int r){
        if(l == r){
            return l;
        }
        int mid = l + (r - l) / 2;
        // 如果mid处于上升序列，则峰值在右边， 否则在左边
        if(nums[mid] < nums[mid+1]){
            return findPeakElementHelper(nums, mid+1, r);
        }
        return findPeakElementHelper(nums, l, mid);
    }
}
