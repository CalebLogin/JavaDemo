package com.caleb.algorithm.leetcode;

/**
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @author：hanzhigang
 * @Date : 2021/3/30 10:45 PM
 */
public class Reverse7 {
    public int reverse(int x) {

        int res = 0;
        int num;
        int flag = 1;   // 如果x小于0，flag = -1

        if (x < 0) {
            flag = -1;
            x = -x;
        }

        while (x != 0) {
            num = x % 10;
            if (res > (Integer.MAX_VALUE - num) / 10) {
                return 0;
            }
            res = res * 10 + num;
            x /= 10;
        }

        return res * flag;
    }
}
