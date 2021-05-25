package com.caleb.alorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。
 * 返回所有这些可能的句子。
 * <p>
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * @author：hanzhigang
 * @Date : 2021/4/23 10:47 PM
 */
public class WordBreak140 {
    List<String> res = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> wordBreak(String s, List<String> wordDict) {
        helper(s,0,wordDict);
        return res;
    }

    private void helper(String s, int start, List<String> wordDict) {
        if (start == s.length()) {
            res.add(stringBuilder.toString().trim());
            return;
        }
        for (String str : wordDict) {
            int newStart = start + str.length();
            if (newStart > s.length()) {
                continue;
            }
            if (s.indexOf(str, start) == start) {
                int len = stringBuilder.length();
                stringBuilder.append(str).append(" ");
                helper(s, newStart, wordDict);
                stringBuilder.delete(len,stringBuilder.length());
            }
        }
    }

    public static void main(String[] args) {
        WordBreak140 wordBreak140 = new WordBreak140();

    }

}
