package com.eric.alorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * @Date : 2021/4/23 20:42
 */
public class WordBreak139 {

    boolean flag = false;   // 标记当前是否空格分割成功
    Map<String, Integer> map;   //  存储wordDict中的string在s中出现的次数

    /**
     * kmp问题
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        map = new HashMap<>();  // 存储wordDict中的string对应在s中出现的次数
        for (String str : wordDict) {
            map.put(str, 0);
        }


        helper(s, 0);
        return flag;

    }

    private void helper(String s, int i) {
        if (i == s.length()) {  // 如果当前遍历到了最后，判断hash中的字符是否都包含了。如果没有包含的，则当前遍历的顺序是不对的，否则就是对的
            int count = 0;
            for (Integer j : map.values()) {
                if (j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                flag = true;
            }

            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (flag) {
                break;
            }
            if (map.getOrDefault(s.substring(i, j + 1), -1) != -1) {    // 当前字符串在hash表中存在
                map.put(s.substring(i, j + 1), map.get(s.substring(i, j + 1)) + 1); // 将当前字符串在hash中对应的数值加1
                helper(s, j + 1);
                map.put(s.substring(i, j + 1), map.get(s.substring(i, j + 1)) - 1);
            }
        }
    }

    public static void main(String[] args) {
        WordBreak139 wordBreak139 = new WordBreak139();
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(wordBreak139.wordBreak("catsandog", list));
    }
}
