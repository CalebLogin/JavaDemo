package com.caleb.algorithm.leetcode;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @author：hanzhigang
 * @Date : 2021/5/29 11:49 PM
 */
public class IsAnagram242 {

    /**
     * hash
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] i1 = new int[26];
        int[] i2 = new int[26];
        for (char c : s.toCharArray()) {
            i1[c-'a'] = i1[c-'a']+1;
        }
        for (char c : t.toCharArray()) {
            i2[c-'a'] = i2[c-'a']+1;
        }
        for(int i = 0;i<i1.length;i++){
            if(i1[i] != i2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram242 isAnagram242 = new IsAnagram242();
        System.out.println(isAnagram242.isAnagram("rat", "cat"));
    }
}
