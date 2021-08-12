package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author：hanzhigang
 * @Date : 2021/4/10 9:54 PM
 */
public class Subsets78 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(0, nums);
        return res;
    }

    private void helper(int curIndex, int[] nums) {
        if (curIndex == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[curIndex]);
        helper(curIndex + 1, nums);
        list.remove(list.size() - 1);
        helper(curIndex + 1, nums);
    }
}
