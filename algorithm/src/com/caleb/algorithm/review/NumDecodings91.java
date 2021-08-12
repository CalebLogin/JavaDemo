package com.caleb.algorithm.review;

/**
 * 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * @author: hanzhigang
 * @Date : 2021/4/22 21:31
 */
public class NumDecodings91 {
    /**
     * 使用动态规划的方法
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        if (cs[0] == '0') {
            return 0;
        }
        int curr = 1, prev = 1;
        for (int i = 1; i < n; i++) {
            int temp = curr;
            if (cs[i] == '0') {
                if (cs[i - 1] == '1' || cs[i - 1] == '2') {
                    curr = prev;
                } else {
                    return 0;
                }
            } else {
                if (cs[i - 1] == '1' || cs[i - 1] == '2' && cs[i] - '0' < 7) {
                    curr = prev + curr;
                }
            }
            prev = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        NumDecodings91 numDecodings91 = new NumDecodings91();
        System.out.println(numDecodings91.numDecodings("228"));
    }
}
