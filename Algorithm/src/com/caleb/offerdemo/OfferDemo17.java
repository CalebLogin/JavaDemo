package com.eric.offerdemo;

import java.io.PrintWriter;

/**
 * 打印从1到最大的n位数
 *
 * @author：hanzhigang
 * @Date : 2021/3/4 1:53 PM
 */
public class OfferDemo17 {

    int num = 0;
    int res[];

    StringBuilder sbuilder;
    char[] nums, loop = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int n;

    public int[] printNumbers(int n) {

        num = (int) Math.pow(10, n) - 1;
        res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public String printNumbers1(int n) {

        this.n = n;
        sbuilder = new StringBuilder();
        nums = new char[n];
        dfs(0);
        sbuilder.deleteCharAt(sbuilder.length() - 1);
        return sbuilder.toString();
    }

    void dfs(int x) {
        if (x == n) {
            sbuilder.append(String.valueOf(nums) + ',');
            return;
        }
        for (char c : loop) {
            nums[x] = c;
            dfs(x + 1);
        }
    }


    public static void main(String[] args) {
        OfferDemo17 offerDemo17 = new OfferDemo17();
        offerDemo17.printNumbers(1);
    }
}
