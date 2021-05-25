package com.caleb.alorithm.leetcode;

/**
 * Z字形变换
 * 一共生成numRows行，除第一行和最后一行外，每一行都是 i + (2 ~ 2 * numRows -2)，step每次加2
 *
 * @author：hanzhigang
 * @Date : 2021/3/30 9:24 PM
 */
public class Convert6 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 在遍历的时候，最大的步长
        int totalStep = 2 * numRows - 2;
        int step = 0;
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历z的最上一行
        for (int i = 0; i < s.length(); i += totalStep) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1 && step < totalStep; i++) {
            step = step + 2;
            int newStep = step;
            for (int j = i; j < s.length(); newStep = totalStep - newStep,j += newStep) {
                stringBuilder.append(s.charAt(j));
            }
        }
        // 遍历z的最下一行
        for (int i = numRows - 1; i < s.length(); i += totalStep) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Convert6 convert6 = new Convert6();
        System.out.println(convert6.convert("PAYPALISHIRING", 2));
    }
}
