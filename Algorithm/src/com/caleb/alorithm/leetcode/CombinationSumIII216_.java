package com.eric.alorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合数III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 *
 * @author: hanzhigang
 * @Date : 2021/4/24 19:22
 */
public class CombinationSumIII216_ {

    List<List<Integer>> res = new ArrayList<>();    // 结果集
    List<Integer> list = new ArrayList<>(); // 临时列表

    public List<List<Integer>> combinationSum3(int k, int n) {
        // 如果 (k + 1) * k > 2 * n 说明不存在不重复的数字组合
        if ((k + 1) * k > 2 * n) {
            return new ArrayList<>();
        }
        helper(k, 1, n);
        return res;
    }

    private void helper(int l, int s, int n) {
        if (l == 1) {
            list.add(n);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for (int i = s; i < 10; i++) {
            // 如果取当前i，剩下的值比剩余的次数 * 9还要大，说明当前i不够大，不能完成排列
            if (n - i > (l - 1) * 9) {
                continue;
            }
            // 如果取当前i，剩下的值比剩余的次数*当前的最小值还要小，说明当前i太大了，也不能完成排列
            if (n - i < (l - 1) * (i + 1)) {
                break;
            }
            list.add(i);
            helper(l - 1, i + 1, n - i);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 用二进制实现
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3_(int k, int n) {
        return null;
    }

}
