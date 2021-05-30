package com.caleb.algorithm.leetcode;

/**
 * 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * @author：hanzhigang
 * @Date : 2021/5/29 10:55 PM
 */
public class ProductExceptSelf238 {

    /**
     * 左右两次遍历
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length; // 数组的长度
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = len - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }

    public static void main(String[] args) {
        ProductExceptSelf238 productExceptSelf238 = new ProductExceptSelf238();
        int[] res = productExceptSelf238.productExceptSelf(new int[]{1, 2, 3, 4});
        for (Integer i : res) {
            System.out.print(i + "--");
        }
    }
}
