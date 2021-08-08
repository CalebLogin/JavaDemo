package com.caleb.algorithm.offerdemo;

/**
 * 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @author：hanzhigang
 * @Date : 2021/3/17 9:50 PM
 */
public class OfferDemo58_II {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) sb.append(s.charAt(i));
        for (int i = 0; i < n; i++) sb.append(s.charAt(i));
        return sb.toString();
    }

    public String reverseLeftWords1(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }
}
