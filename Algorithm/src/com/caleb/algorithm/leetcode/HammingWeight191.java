package com.caleb.algorithm.leetcode;

/**
 * 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）
 *
 * @author：hanzhigang
 * @Date : 2021/5/8 11:23 PM
 */
public class HammingWeight191 {
    /**
     * 位运算
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (; n != 0;) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }

    /**
     * 位运算优化
     * 6 & (6-1) = 4  6 = (110)   4 = (100)
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

}
