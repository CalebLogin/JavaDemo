package com.caleb.algorithm.leetcode;

/**
 * 字符串转换整数 (atoi)
 * <p>
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。
 * 具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 *
 * @Date : 2021/3/30 11:14 PM
 */
public class MyAtoi8 {
    public int myAtoi(String s) {
        // 返回结果
        int result = 0;
        int flag = 1;   // 当为负数的时候，flag = -1
        int i = 0;  // 开始遍历的下标
        String s1 = s.trim();   // 去掉空格

        // 开头不符合规则的话返回 0
        if (s1.length() == 0 || (s1.charAt(0) != '+' && s1.charAt(0) != '-' && s1.charAt(0) - '0' < 0 && s1.charAt(0) - '0' > 9)) {
            return result;
        }
        // 判断数字的正负
        if (s1.charAt(0) == '-') flag = -1;
        if (s1.charAt(0) == '-' || s1.charAt(0) == '+') i = 1;

        for (; i < s1.length(); i++) {
            if (s1.charAt(i) - '0' < 0 || s1.charAt(i) - '0' > 9) break;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (s1.charAt(i) - '0') > Integer.MAX_VALUE % 10)) {
                result = Integer.MAX_VALUE;
                break;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && -(s1.charAt(i) - '0') < Integer.MIN_VALUE % 10)) {
                result = Integer.MIN_VALUE;
                break;
            }
            // 注意这里
            result = result * 10 + flag * (s1.charAt(i) - '0');
        }

        return result;
    }

    public static void main(String[] args) {
        MyAtoi8 myAtoi = new MyAtoi8();
        System.out.println(myAtoi.myAtoi("-3147483648"));
        System.out.println(Integer.MIN_VALUE);
    }
}
