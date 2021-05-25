package com.caleb.offerdemo;

/**
 * 旋转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * @author：hanzhigang
 * @Date : 2021/3/17 9:42 PM
 */

public class OfferDemo58_I {

    public static String reverseWords(String s) {
        // 将字符串首尾的空格去掉
        s = s.trim();
        String[] ss = s.split("[ ]+");
        StringBuilder sb = new StringBuilder();
        for(int i = ss.length-1;i>=0;i--){
            sb.append(ss[i]+" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        reverseWords("a good   example");
    }
}
