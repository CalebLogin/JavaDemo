package com.caleb.algorithm.offerdemo;

/**
 * 1~n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * @author：hanzhigang
 * @Date : 2021/3/11 10:09 PM
 */
public class OfferDemo43 {
    public static int countDigitOne(int n) {
        int countSum = 0;
        for(int i = 1;i<=n;i++){
            countSum+= count(i);
        }
        return countSum;
    }
    public  static int count(int num) {
        int sum = 0;
        while (num >= 10) {
            sum += num % 10 == 1 ? 1 : 0;
            num /= 10;
        }
        return num == 1 ? ++sum : sum;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }
}

