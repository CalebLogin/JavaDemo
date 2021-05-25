package com.caleb.offerdemo;

/**
 * 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 思路1：回溯方法
 * 思路2：能不能用动态规划,可以
 *
 * @author：hanzhigang
 * @Date : 2021/3/12 9:42 PM
 */
public class OfferDemo46 {
    private int count = 0;  // 统计一共有多少个

    public int translateNum(int num) {
//      如果数字==0，返回0
        if (num == 0) {
            return 1;
        }
        String res = String.valueOf(num);
//      定义回溯方法体
        helper(res, 0);
        return count;
    }

    public void helper(String s, int startIndex) {
//      如果等于字符串长度，说明遍历结束，返回
        if (startIndex >= s.length()) {
            ++count;
            return;
        }
        for (int i = 1; i + startIndex <= s.length(); i++) {
//          如果当前结果大于26，说明不符合，直接剪枝
            int j = Integer.parseInt(s.substring(startIndex, startIndex + i));
            if (j == 0 && i + startIndex != s.length()) {
                continue;
            } else if (j == 0 && i + startIndex == s.length()) {
                count++;
                continue;
            }
            if (j >= 26) {
                return;
            }
//          进行深层次的遍历
            helper(s, startIndex + i);
        }
    }

//  动态规划问题dp[i] = (dp[i-1] + dp[i-2]) / dp[i-1]
    public int translateNum1(int num) {

        String str = String.valueOf(num);
        int a = 1;
        int b = 1;
        for (int i = 2; i <= str.length(); i++) {
            int j=Integer.parseInt(str.substring(i - 2, i));
            int c =  10 <=j && j < 26 ? a+b : b;
            a = b;
            b = c;

        }
        return b;
    }

    public static void main(String[] args) {
        OfferDemo46 offerDemo46 = new OfferDemo46();
        System.out.println(offerDemo46.translateNum1(12258));
    }

}
