package com.caleb.alorithm.leetcode;

import java.util.Arrays;

/**
 * 分割回文串III
 * 给你一个由小写字母组成的字符串 s，和一个整数 k。
 * <p>
 * 请你按下面的要求分割字符串：
 * <p>
 * 首先，你可以将 s 中的部分字符修改为其他的小写英文字母。
 * 接着，你需要把 s 分割成 k 个非空且不相交的子串，并且每个子串都是回文串。
 * 请返回以这种方式分割字符串所需修改的最少字符数。
 *
 * @author：hanzhigang
 * @Date : 2021/4/13 7:58 PM
 */
public class PalindromePartition1278_ {
    int count = 0;  // 所需修改的最小字符数
    boolean[][] f;

    public int palindromePartition(String s, int k) {
        int n = s.length();
        char[] c = s.toCharArray();

        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[0], true);
        }

        // 进行预处理,找出哪些位置是回文串
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = c[i] == c[j] && f[i + 1][j - 1];
            }
        }
        return count;
    }

    private void helper() {

    }
}
