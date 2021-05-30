package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * @author：hanzhigang
 * @Date : 2021/4/7 7:30 PM
 */
public class Permute46 {

    // 返回结果
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(nums,0);
        return res;
    }

    public void helper(int[] nums, int index) {
        // 如果当前数字遍历完,返回结果
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(Integer i:nums){
                temp.add(i);
            }
            res.add(temp);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // 交换当前数字
            swap(nums, index, i);
            helper(nums, index + 1);
            // 将交换的数字还原
            swap(nums,i,index);
        }
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


}
