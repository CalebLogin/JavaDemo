package com.eric.alorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本计算机II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 *
 * @author: hanzhigang
 * @Date : 2021/5/18 20:20
 */
public class Calculate227 {
    public int calculate(String s) {
        List<Integer> num = new ArrayList<>();
        List<Character> c = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
                i++;
            }
            if (stringBuilder.length() != 0) {
                num.add(Integer.parseInt(stringBuilder.toString()));
            }
            if (i < s.length() && (s.charAt(i) == '*' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '+')) {
                c.add(s.charAt(i));
            }
        }
        res = num.get(0);
        for (int i = 0; i < c.size(); i++) {
            int temp = 0;
            int cur = i;
            if((c.get(i) == '*' || s.charAt(i) == '/')){
                if (c.get(i) == '*') {
                    res *= num.get(i + 1);
                } else {
                    res /= num.get(i + 1);
                }
            }else{
                temp = num.get(i + 1);
                while (i + 1 < c.size() && (c.get(i + 1) == '*' || c.get(i + 1) == '/')) {
                    if (c.get(i + 1) == '*') {
                        temp *= num.get(i + 2);
                    } else {
                        temp /= num.get(i + 2);
                    }
                    i++;
                }
                if (c.get(cur) == '+') {
                    res += temp;
                }else{
                    res -= temp;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Calculate227 calculate227 = new Calculate227();
        System.out.println(calculate227.calculate(" 3333+ 2/2+1+2/2 "));
    }
}
