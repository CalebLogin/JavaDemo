package com.eric.alorithm.leetcode;

/**
 * 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * @author：hanzhigang
 * @Date : 2021/4/5 9:04 PM
 */
public class Divide29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        int flagEnd = 1;
        int flagDivisor = 1;
        if (dividend < 0) {
            flagEnd = -flagEnd;
        }
        if (divisor < 0) {
            flagDivisor = -flagDivisor;
        }
        int count = 0;  // 相减的次数
        if (flagEnd * flagDivisor == 1) {
            if (flagEnd == -1) {
                while (dividend <= 0 && dividend <= divisor) {
                    dividend -= divisor;
                    count++;
                }
            } else {
                while (dividend >= 0 && dividend >= divisor) {
                    dividend -= divisor;
                    count++;
                }
            }
        } else {
            if (flagEnd == -1) {
                while (dividend <= 0) {
                    dividend += divisor;
                    count++;
                }
            } else {
                while (dividend >= 0) {
                    dividend += divisor;
                    count++;
                }
            }
            count--;
        }
        return flagEnd * flagDivisor * count;
    }

    public int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        int fix = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor > 0) {
                dividend += divisor;
                fix++;
            } else {
                dividend -= divisor;
                fix--;
            }
        }
        int res = 0;
        boolean flag = (dividend > 0) ^ (divisor > 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            int x = divisor;
            int r = 1;
            if (x  <= (dividend >> 1)) {    // dividend >> 1 为了防止 x <<= 1的时候32位整数溢出
                x <<= 1;
                r <<= 1;
            }
            dividend -= x;
            res += r;
        }
        return (flag ? res : -res) + fix;
    }
}
