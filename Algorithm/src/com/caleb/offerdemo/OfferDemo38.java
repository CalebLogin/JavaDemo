package com.caleb.offerdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 字符串的排列，回溯方法
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * [0,1,2],[0,2,1],[1,0,2],[1,2,0],[2,0,1],[2,1,0]
 *
 * @author：hanzhigang
 * @Date : 2021/3/11 4:38 PM
 */
public class OfferDemo38 {
    private List<String> list = new ArrayList<>();
    private char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        helper(0);
        return list.toArray(new String[c.length]);
    }

//  通过固定某一位置的值，然后进行全排列，之后再改变固定位置的值，再进行全排列，不断的改变c数组中值的位置来实现全排列
    private void helper(int startIndex) {
        if (startIndex == c.length - 1) {
            list.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = startIndex; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, startIndex);
            helper(startIndex + 1);
            swap(i, startIndex);
        }

    }

    private void swap(int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
