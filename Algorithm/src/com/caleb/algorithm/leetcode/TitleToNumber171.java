package com.caleb.algorithm.leetcode;

/**
 * Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * @author：hanzhigang
 * @Date : 2021/5/7 11:32 PM
 */
public class TitleToNumber171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int len = columnTitle.length();
        for (int i = 0; i < len; i++) {
            char c = columnTitle.charAt(i);
            res += (c-'A'+1) * Math.pow(26,len-i-1);
        }
        return res;
    }

    public static void main(String[] args) {
        TitleToNumber171 titleToNumber171 = new TitleToNumber171();
        System.out.println(titleToNumber171.titleToNumber("ZY"));
    }
}
