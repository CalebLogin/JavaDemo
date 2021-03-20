package com.eric.offerdemo;

/**
 * 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 摩尔投票法，如果记众数票为+1，非众数为-1，则总和一定 > 0
 * 若前a个票数为0，则剩下的（n-a）的票数肯定 > 0
 *
 * @author：hanzhigang
 * @Date : 2021/3/11 5:34 PM
 */
public class OfferDemo39 {

    public int majorityElement(int[] nums) {

//      我的方法
        int count = 0;
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == maxNum) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    maxNum = nums[i];
                    count = 0;
                }
            }
        }
//      验证是不是众数
        for (int num : nums) {
            if (num == maxNum) count++;
        }



//      评论区方法
        for (int num : nums) {
            if (count == 0) maxNum = num;
            count += num == maxNum ? 1 : -1;
        }
        return count > nums.length / 2 ? maxNum : 0;

    }
}
