package com.caleb.offerdemo;

/**
 * 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * @author：hanzhigang
 * @Date : 2021/3/11 10:35 PM
 */
public class OfferDemo44 {
    public static int findNthDigit(int n) {
        int digit = 0;  // 位数
        int index = 0; // 前面的start * digit总和
        int sd = n / 9; // 取start * digit
        int m, i, res = 0;  // m表示还剩几位，res返回结果
        while (index <= sd) {
            digit++;
            index += (Math.pow(10, digit - 1)) * digit;
        }
//      n前面的start*digit的和
        index -= ((Math.pow(10, digit - 1)) * digit);
//      在当前digit位数下定位到某一位数
        i = (int) ((Math.pow(10, digit - 1)) + ((n - (index * 9)) / digit)) - 1;
//      m表示在取了所有整数的情况下，还应该走多少位
        m = (n - (index * 9)) % (digit);
        System.out.println(digit + "," + index + "," + i + "," + m);
//      如果不走的话说明是上一个值的最后一位，否则是下一个值的第m位
        if (m == 0) {
            return i % 10;
        } else {
            int pre = i + 1;
            while (digit != m-1) {
                res = pre % 10;
                pre /= 10;
                digit--;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(13));
    }
}
