package com.eric.alorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符串的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * @author：hanzhigang
 * @Date : 2021/3/24 10:18 PM
 */
public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len = (i - len <= map.getOrDefault(c[i], -1)) ?  (i - map.getOrDefault(c[i],-1)) : (len+1);
            if(len > maxLen){
                maxLen = len;
            }
            map.put(c[i], i);
        }
        return maxLen;
    }
}
