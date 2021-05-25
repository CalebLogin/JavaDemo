package com.caleb.alorithm.leetcode;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author：hanzhigang
 * @Date : 2021/4/4 4:42 PM
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        // 空字符串数组，返回""
        if (strs.length == 0) {
            return "";
        }

        boolean flag = true; // 当出现不一样的前缀的时候为false
        int curIndex = 0;   // 遍历下标
        int minLen = Integer.MAX_VALUE; //  记录最短字符串的长度
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        // 遍历下标不超过最短字符串的长度
        while (curIndex < minLen) {
            Character c = strs[0].charAt(curIndex);
            for (int i = 0; i < strs.length; i++) {
                if (c != strs[i].charAt(curIndex)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            curIndex++;
        }
        return strs[0].substring(0, curIndex);
    }
}
