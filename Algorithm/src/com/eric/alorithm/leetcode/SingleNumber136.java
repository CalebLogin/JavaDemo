package com.eric.alorithm.leetcode;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * @author：hanzhigang
 * @Date : 2021/4/21 9:46 PM
 */
public class SingleNumber136 {
    /**
     * 利用异或来进行筛选
     * 5 ^ 5 = 0
     * 5 ^ 6 ^ 5 = 6
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber136 singleNumber136 = new SingleNumber136();
        System.out.println(singleNumber136.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
