package com.caleb.algorithm.leetcode;

import java.util.*;

/**
 * 组合总和
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * @author: hanzhigang
 * @Date : 2021/4/24 19:22
 */
public class CombinationSum39 {

    /**
     * 思想：回溯加剪枝
     *
     * @param candidates
     * @param target
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        helper(0, target, candidates);
        return res;
    }

    private void helper(int start, int target, int[] candidaties) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidaties.length; i++) {
            if (target - candidaties[i] >= 0) {
                list.add(candidaties[i]);
                helper(i, target - candidaties[i], candidaties);
                list.remove(list.size() - 1);
            }
        }
    }


}
