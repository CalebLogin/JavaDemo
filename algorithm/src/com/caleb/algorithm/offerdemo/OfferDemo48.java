package com.caleb.algorithm.offerdemo;

import java.util.HashMap;

/**
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * @author：hanzhigang
 * @Date : 2021/3/13 10:47 PM
 */
public class OfferDemo48 {
    /**
     * 动态规划的思想，dp[i] = {dp[i-1]+1,j-i},还可以利用双指针加hash的想法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;     // 最长子字符串长度
        int curLen = 0;     // 当前子字符串长度
        // 记录字符每次出现的索引
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
//          如果有重复字符，则当前字符结尾的最长子字符串长度为i-j。
//          如果i-j 大于curLen的话说明当前字符出现的位置太过早，已经不在比较范围内，则cur++，否则i-j
            curLen = curLen < i - map.getOrDefault(s.charAt(i),-1) ? curLen + 1 : i - map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            maxLen = Math.max(curLen,maxLen);

        }
//      返回结果
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
