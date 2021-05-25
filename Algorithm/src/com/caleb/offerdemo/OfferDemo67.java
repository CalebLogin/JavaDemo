package com.caleb.offerdemo;

/**
 * 把字符串转换成整数
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * @author：hanzhigang
 * @Date : 2021/3/21 10:29 PM
 */
public class OfferDemo67 {


    public static int strToInt(String str) {
        // 判断正数还是负数,默认是正数
        boolean flag = true;
        // 返回结果
        int res = 0;
        // 判断是否已经开始判断数字，即已经碰到了正数或者负数,默认为false
        boolean beginFlag = false;

        for (int i = 0; i < str.length(); i++) {
            boolean temp = (str.charAt(i) != '+' && str.charAt(i) != '-'
                    && (str.charAt(i) - '0' < 0 && str.charAt(i) - '0' > 9));
            if (temp && !beginFlag) {
                break;
            } else if (beginFlag && temp) {
                continue;
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-'
                    || (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9)) {
                beginFlag = true;
                if (str.charAt(i) == '+') {
                    continue;
                } else if (str.charAt(i) == '-') {
                    flag = false;
                } else {
                    if (((long) res * 10 + (str.charAt(i) - '0')) > Integer.MAX_VALUE) {
                        res = !flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                        break;
                    }
                    res = res * 10 + (str.charAt(i) - '0');
                }
            }
        }
        return flag ? res : -1 * res;
    }

    public int strToInt1(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if(length == 0) return 0;
        while(str.charAt(i) == ' ')
            if(++i == length) return 0;
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for(int j = i; j < length; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("....."));
    }
}
