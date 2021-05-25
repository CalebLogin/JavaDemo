package com.caleb.alorithm.leetcode;

/**
 * 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * @author：hanzhigang
 * @Date : 2021/4/28 11:18 PM
 */
public class JudgeSquareSum633 {
    public boolean judgeSquareSum(int c) {
        int s = (int) Math.sqrt(c);
        int l = 0, r = s;
        while (l <= r) {
            int res = (int) (Math.pow(l, 2) + Math.pow(r, 2));
            System.out.println(res);
            if (res > c) {
                r--;
            } else if (res < c) {
                l++;
            } else {
                break;
            }
        }
        return l <= r;
    }

    /**
     * 费马平方和
     * @param c
     * @return
     */
    public boolean judgeSquareSum1(int c) {
        for (int i = 2; i * i <= c; i++) {
            int cnt = 0;
            while (c % i == 0) {
                cnt++;
                c /= i;
            }
            if (i % 4 == 3 && cnt % 2 != 0) return false;
        }
        return c % 4 != 3;
    }

    public static void main(String[] args) {
        JudgeSquareSum633 judgeSquareSum633 = new JudgeSquareSum633();
        System.out.println(judgeSquareSum633.judgeSquareSum(4));
    }
}
