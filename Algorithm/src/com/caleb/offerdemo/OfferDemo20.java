package com.caleb.offerdemo;

/**
 * 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * @author：hanzhigang
 * @Date : 2021/3/5 10:14 AM
 */
public class OfferDemo20 {
    //  表示数值的字符串
    public boolean isNumber(String s) {

//      如果是空字符串，返回false
        if (s.isEmpty() || s.length() == 0) {
            return false;
        }
        s = s.toLowerCase().trim().toString();
//      e的位置
        int index = -1;
//      遍历位置
        int j = 0;
//      小数点出现的次数
        int psum = 0;
//      true表示为非e数值，false表示为e表达式数值
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e') {
                flag = false;
                index = i;
            }
        }
//      若字符前面带有符号，将索引向后移
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            j = 1;
        }
//      如果为非e数值
        if (flag) {
            for (; j < s.length(); j++) {
                if (psum > 1 || s.charAt(s.length() - 1) == '.') {
                    return false;
                }
                if (!Character.isDigit(s.charAt(j)) && s.charAt(j) != '.') {
                    return false;
                }
                if (s.charAt(j) == '.') {
                    psum++;
                }
            }
        } else {
            if (index < 1 || index >= s.length() - 2) {
                return false;
            }
            for (; j < index; j++) {
                if (psum > 1) {
                    return false;
                }
                if (!Character.isDigit(s.charAt(j)) && s.charAt(j) != '.') {
                    return false;
                }
                if (s.charAt(j) == '.') {
                    psum++;
                }
            }
            if (s.charAt(index + 1) != '+' && s.charAt(index + 1) != '-') {
                return false;
            }
            for (j += 2; j < s.length(); j++) {
                if (!Character.isDigit(s.charAt(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new OfferDemo20();
    }
}
