package com.eric.alorithm.leetcode;

/**
 * 数组异或操作
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 * @author：hanzhigang
 * @Date : 2021/5/7 9:57 PM
 */
public class XorOperation1486 {

    public int xorOperation(int n, int start) {
        int res = start;
        for (int j = start+2; j < start + 2 * n; j+=2) {
            res ^= j;
        }
        return res;
    }

    public static void main(String[] args) {
        XorOperation1486 xorOperation1486 = new XorOperation1486();
        System.out.println(xorOperation1486.xorOperation(4, 3));
    }
}
