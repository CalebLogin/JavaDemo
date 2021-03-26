package com.eric.offerdemo;

/**
 * 调整数组顺序使奇数在偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * @author：hanzhigang
 * @Date : 2021/3/5 2:15 PM
 */
public class OfferDemo21 {
    public int[] exchange(int[] nums) {
//      如果是空数组返回null
        if (nums.length == 0) {
            return null;
        }
//      使用双指针，通过遍历来使奇偶数交换位置
        int i = 0, j = nums.length - 1;
        while (i < j) {
//          如果遍历的是奇数，接着向后查找
            while ((nums[i] & 1) == 1) {
                if (i < j) {
                    i++;
                }else{
                    break;
                }
            }
//          如果遍历的是偶数，继续向前查找
            while ((nums[j] & 1) == 0) {
                if (j > i) {
                    j--;
                }else{
                    break;
                }
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        OfferDemo21 offerDemo21 = new OfferDemo21();
        int[] a = offerDemo21.exchange(new int[]{1, 2, 3, 4});
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}
