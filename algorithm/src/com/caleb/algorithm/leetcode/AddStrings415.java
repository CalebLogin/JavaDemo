package com.caleb.algorithm.leetcode;

/**
 * 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 11:01 PM
 */
public class AddStrings415 {

    public String addStrings(String num1, String num2) {
        if(num1.length() == 0){
            return num2;
        }
        if(num2.length() == 0){
            return num1;
        }

        int add = 0;    // 记录是否进位
        StringBuilder sb = new StringBuilder();
        int i,j;

        for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int num = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + add;
            add = num / 10;
            num %= 10;
            sb.append(num);
        }
        for(;i>=0;i--){
            int num = (num1.charAt(i) - '0') + add;
            add = num / 10;
            num %= 10;
            sb.append(num);
        }
        for(;j>=0;j--){
            int num = (num2.charAt(j) - '0') + add;
            add = num / 10;
            num %= 10;
            sb.append(num);
        }
        if(add != 0) sb.append(add);
        return sb.reverse().toString();
    }
}
