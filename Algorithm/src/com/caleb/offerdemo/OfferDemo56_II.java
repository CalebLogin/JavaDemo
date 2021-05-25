package com.caleb.offerdemo;

/**
 * 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
 * <p>
 * 思路1：出现三次的数字，在二进制中，每一位都可以被3取余为0，剩下的就是多的那个数字
 *
 * @author：hanzhigang
 * @Date : 2021/3/16 9:46 PM
 */


public class OfferDemo56_II {
    public int singleNumber(int[] nums) {
        // 存储每一位出现1的次数
        int[] res = new int[32];
        for (int num : nums) {
            // 对整数的每一位进行统计，把位数为1的添加到数组的相应位置
            int count = 1;
            // 数值的低位被存储到数组的高位
            for (int i = 31; i >= 0; i--) {
                if((count & num) != 0) res[i] ++;
                count <<= 1;
            }
        }
        int num = 0;
        // 在数的高位开始，添加一次高位就将高位向左移
        // 高位为0的话，在做左移运算的时候，num一直为0，知道遇到为1的
        for (int i = 0; i <32 ; i++){
            num <<= 1;
            num += res[i] % 3;
        }
        return num;
    }

    public static void main(String[] args) {

    }
}
