package com.eric.alorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * @author：hanzhigang
 * @Date : 2021/4/12 8:53 PM
 */
public class Partition131 {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    boolean[][] f;

    public List<List<String>> partition(String s) {
        char[] c = s.toCharArray();
        f = new boolean[s.length()][s.length()];

        // 将 f 全部置为true
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(f[i], true);
        }

        // 进行预处理，找出可以是回文串的i,j
        for (int i = c.length-1; i >= 0; i--) {
            for (int j = i + 1; j <c.length; j++) {
                f[i][j] = f[i + 1][j - 1] && (c[i] == c[j]);
            }
        }

        // 进行回溯
        helper(0, s.length(), s);
        return res;

    }

    public void helper(int i, int len, String s) {
        if (i == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < len; j++) {
            if (f[i][j]) {
                list.add(s.substring(i, j + 1));
                helper(j + 1, len, s);
                list.remove(list.size() - 1);
            }
        }
    }

}
