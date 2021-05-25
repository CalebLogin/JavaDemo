package com.eric.alorithm.leetcode;

/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * 动态规划的思想
 *
 * @author：hanzhigang
 * @Date : 2021/3/29 9:41 PM
 */
public class LongestPalindrome5 {

    public String longestPalindrome(String s) {

        char[] chars = s.toCharArray();

        // 记录字符串由i到j是不是回文串
        boolean[][] res = new boolean[s.length()][s.length()];

        for (int i = 0; i < chars.length; i++) {
            res[i][i] = true;
        }

        //  i 到 j 的步长依次递增，来判断是不是回文串
        for (int k = 1; k < s.length(); k++) {
            for (int i = 0, j = i + k; j < s.length(); i++, j++) {
                if (j - 1 == i) {
                    if (chars[i] == chars[j]) {
                        res[i][j] = true;
                    }
                } else if (chars[i] == chars[j] && res[i + 1][j - 1]) {
                    res[i][j] = true;
                }

            }
        }

        int start = 0, end = 0;
        int maxLen = 0;
        // 找到j-i最大的回文串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (res[i][j] && j - i > maxLen) {
                    maxLen = j - i;
                    start = i;
                    end = j;
                }
            }
        }


        return s.substring(start, end + 1);
    }

    /**
     * 中心扩散的思想
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {

        char[] chars = s.toCharArray();
        int start = 0, end = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            int evenLen = expandAroudCenter(chars, i, i);
            int oddLen = expandAroudCenter(chars, i, i + 1);
            int len = Math.max(evenLen, oddLen);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    public static int expandAroudCenter(char[] c, int i, int j) {
        while (i >= 0 && j < c.length && c[i] == c[j]){
            --i;
            ++j;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("caba"));
    }
}
