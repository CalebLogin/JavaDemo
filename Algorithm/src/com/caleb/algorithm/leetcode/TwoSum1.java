package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 10:39 PM
 */
public class TwoSum1 {

    /**
     * 使用map
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target-nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
