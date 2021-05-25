package com.eric.alorithm.leetcode;

/**
 * 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 【外观数列】是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 * @Date : 2021/4/6 8:23 PM
 */
public class CountAndSay38 {

    public String countAndSay(int n) {
        String res = String.valueOf(1);
        for (int i = 1; i < n; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            int count = 1;
            char curNum = res.charAt(0);
            for (int index = 1; index < res.length(); index++) {
                if (curNum == res.charAt(index)) {
                    count++;
                } else {
                    stringBuffer.append(count);
                    stringBuffer.append(curNum);
                    count = 1;
                    curNum = res.charAt(index);
                }
            }
            stringBuffer.append(count);
            stringBuffer.append(curNum);
            res = stringBuffer.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        CountAndSay38 countAndSay38 = new CountAndSay38();
        System.out.println(countAndSay38.countAndSay(30));
    }
}
