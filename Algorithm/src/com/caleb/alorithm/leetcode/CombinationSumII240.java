package com.caleb.alorithm.leetcode;

import java.util.*;

/**
 * @author: hanzhigang
 * @Date : 2021/4/24 19:22
 */
public class CombinationSumII240 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        helper(0, target, candidates);
        return res;
    }

    private void helper(int l, int target, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = l; i < candidates.length; i++) {
            // 避免重复
            if(i > l && candidates[i] == candidates[i - 1]){
                continue;
            }
            if (target - candidates[i] >= 0) {
                list.add(candidates[i]);
                helper(i + 1, target - candidates[i], candidates);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII240 combinationSumII240 = new CombinationSumII240();
        List<List<Integer>> list = combinationSumII240.combinationSum2(new int[]{1,2,2,3,4},5);
        for(List<Integer> l: list){
            for(Integer i : l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
