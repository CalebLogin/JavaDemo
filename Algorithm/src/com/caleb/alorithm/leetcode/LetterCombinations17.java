package com.eric.alorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 思路：回溯算法
 *
 * @author：hanzhigang
 * @Date : 2021/4/4 5:30 PM
 */
public class LetterCombinations17 {

    List<String> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    String[] strs;

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0){
            return new ArrayList<>();
        }

        // 将每个数字对应的字母存在字符串数组中
        strs = new String[digits.length()];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = getValue(digits.charAt(i)-'0');
        }
        helper(strs.length, 0);
        return res;
    }

    // 通过递归遍历出每一种可能
    public void helper(int maxDepth, int curDepth) {
        // 如果当前深度是最大深度，则返回当前的结果
        if (curDepth == maxDepth) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(strs[i].charAt(list.get(i)));
            }
            res.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < strs[curDepth].length(); i++) {
            list.add(i);
            helper(maxDepth, curDepth + 1);
            list.remove(list.size() - 1);
        }
    }

    private String getValue(int num) {
        switch (num) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        LetterCombinations17 letterCombinations17 = new LetterCombinations17();
        List<String> list = letterCombinations17.letterCombinations("2");
        for(String str:list){
            System.out.print(str+",");
        }
    }
}
