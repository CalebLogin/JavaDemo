package com.caleb.offerdemo;

import java.util.Arrays;

/**
 * 把数组组成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * @author：hanzhigang
 * @Date : 2021/3/12 8:31 PM
 */


public class OfferDemo45 {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
//      x+y > y+x -> x,y ,or y,x
        Arrays.sort(str, (x, y) -> (x + y).compareTo(y+x));
        StringBuilder sb = new StringBuilder();
        for (String str1 : str) {
            sb.append(str1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OfferDemo45 offerDemo45 = new OfferDemo45();
        int[] arr = new int[]{3, 30, 34, 5, 9};
        System.out.println(offerDemo45.minNumber(arr));
    }

}
