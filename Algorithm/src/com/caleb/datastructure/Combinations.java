package com.caleb.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 回溯算法思想
 * @author：hanzhigang
 * @Date : 2021/3/7 9:07 PM
 */
public class Combinations {

//  定义全局列表
    List<List<Integer>> list;
    List<Integer> list1;

    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        list1 = new ArrayList<>();
        helper(n, k, 1);
        return list;
    }

    public void helper(int n, int k, int startindex) {
//      如果达到k个数字，复制数组，返回
        if (list1.size() == k) {
            List<Integer> list2 = new ArrayList<>(list1);
            list.add(list2);
            return;
        }
//      进行剪枝，优化代码
        for (int i = startindex; i <= n - (k - list1.size()) + 1; i++) {
            list1.add(i);
            helper(n, k, i + 1);
            list1.remove(list1.size() - 1);
        }
    }
}
