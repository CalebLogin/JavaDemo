package com.eric.alorithm.leetcode;

/**
 * 罗马数字转整数
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * @author：hanzhigang
 * @Date : 2021/4/4 12:54 PM
 */
public class RomanToInt13 {
    public int romanToInt(String s) {

        int res = 0;
        int preNum = getValue(s.charAt(0));

        // 字符串自左向右开始遍历
        for (int index = 1; index < s.length(); index++) {
            int c = getValue(s.charAt(index));
            if(c <= preNum){
                res += preNum;
            }else{
                res -= preNum;
            }
            preNum = c;
        }
        res += preNum;
        return res;
    }

    private int getValue(Character c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        RomanToInt13 romanToInt13 = new RomanToInt13();

        System.out.println(romanToInt13.romanToInt("III"));
    }
}
