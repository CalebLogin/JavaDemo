package com.caleb.algorithm.leetcode;

/**
 * 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * @author：hanzhigang
 * @Date : 2021/5/31 10:28 PM
 */
public class IsPowerOfFour342 {
    /**
     * 主要考察偶数个2的幂拼接起来的
     * 2 ** 2n
     * n:1~15
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        return (n>=1 && (n&(n-1))==1) && (n & 0xaaaaaaaa) == 0;
    }

    public static void main(String[] args) {
        IsPowerOfFour342 isPowerOfFour342 = new IsPowerOfFour342();
        System.out.println(isPowerOfFour342.isPowerOfFour(8));
    }
}
