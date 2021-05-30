package com.caleb.algorithm.leetcode;

/**
 * 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
 * 例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。
 * 注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 思路：动态规划
 *
 * @author：hanzhigang
 * @Date : 2021/4/14 7:14 PM
 */
public class NumDecodings91 {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int curr = 1, prev = 1; // dp[0] = 1,dp[-1] = 1
        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) - '0' == 1 || s.charAt(i - 1) - '0' == 2) {
                    curr = prev;
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) - '0' >= 1 && s.charAt(i) - '0' <= 6) {
                    curr += prev;
                }
            }
            prev = tmp;
        }

        return curr;
    }

    public int numDecodings1(String s) {
        int n = s.length();
        int[] dp = new int[n];//到当前数字时的解码种数
        dp[0] = 1;
        if (s.charAt(0) == '0')//如果第一个字母是0，无法解码
            return 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') { // 0出现在1位置上，只有一种解码方式,否则等于dp[i-2]
                    dp[i] = i == 1 ? 1 : dp[i - 2];
                } else {    // 不符合条件，返回0
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) - '0' > 0 && s.charAt(i) - '0' < 7) {   // 如果可以和前一个组成
                    dp[i] = i == 1 ? dp[i - 1] + 1 : dp[i - 1] + dp[i - 2]; // 如果i在1位置上，则等于dp[i-1] + 1，否则等于dp[i-1] + dp[i-2]
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        NumDecodings91 numDecodings91 = new NumDecodings91();
        System.out.println(numDecodings91.numDecodings1("228"));
    }


}
