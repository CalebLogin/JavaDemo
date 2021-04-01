package com.eric.alorithm.leetcode;

/**
 * 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 前i个字符串能否匹配前j个字符规律
 *
 * @author：hanzhigang
 * @Date : 2021/3/31 10:32 PM
 */
public class IsMatch10 {

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();
        boolean[][] flag = new boolean[m + 1][n + 1];   // 记录前i个字符串能否被前j个字符规律匹配
        flag[0][0] = true;  // 空可以匹配空
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (match(s, p, i, j)) {
                        flag[i][j] = flag[i - 1][j - 1];
                    }
                } else {
                    flag[i][j] = flag[i][j - 2];
                    if (match(s, p, i, j - 1)) {
                        flag[i][j] = flag[i - 1][j] || flag[i][j - 2];
                    }
                }
            }
        }

        return flag[m][n];
    }

    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == s.charAt(j - 1);
    }

}
