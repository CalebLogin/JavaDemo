package com.caleb.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串 。
 * 返回 s 所有可能的分割方案。
 *
 * @author：hanzhigang
 * @Date : 2021/3/7 10:50 PM
 */
public class PartitionPalindromeString {

    List<List<String>> res = new ArrayList<>(); // 返回结果列表
    List<String> list1 = new ArrayList<>();     // 每次返回结果的列表

    public List<List<String>> partition(String s) {

        helper(s, 0);
        return res;
    }

    public void helper(String s, int startIndex) {

//      当起始索引等于字符串长度时，说明前面的都是回文串，且已经遍历完成，则返回
        if (startIndex == s.length()) {
            List<String> subRes = new ArrayList<>(list1);
            res.add(subRes);
            return;
        }
//      i是下一个要截取的字符串的位置
        for (int i = startIndex+1; i <= s.length(); i++) {
            String ss = s.substring(startIndex, i);
//          如果是回文串，添加到list，并且判断接下来的字符串
            if (isPalindromeString(ss)) {
                System.out.println("startIndex: " + startIndex + " startIndex+i " + (startIndex + i) + " substring: " + ss);
                list1.add(ss);
                helper(s, i);
                list1.remove(list1.size() - 1);
            }
        }

    }

//  判断是否是回文串
    public boolean isPalindromeString(String s) {

        if (s == null) {
            return false;
        }

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PartitionPalindromeString partitionPalindromeString = new PartitionPalindromeString();
        List<List<String>> list = partitionPalindromeString.partition("aab");
        for (List<String> resList : list) {
            for (String s : resList) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
//        System.out.println(partitionPalindromeString.isPalindromeString(""));
    }
}
