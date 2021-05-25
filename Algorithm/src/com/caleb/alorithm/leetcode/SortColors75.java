package com.eric.alorithm.leetcode;

/**
 * 颜色分类
 *
 * @author：hanzhigang
 * @Date : 2021/4/10 9:44 PM
 */
public class SortColors75 {
    public void sortColors(int[] nums) {
        int n = nums.length;    // 数组长度
        int r = 0, w = 0, b = 0;    // 元素出现的个数
        for (int i = 0; i < n; i++) {
            switch (nums[i]) {
                case 0:
                    r++;
                    break;
                case 1:
                    w++;
                    break;
                case 2:
                    b++;
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (r != 0) {
                nums[i] = r--;
            } else if (w != 0) {
                nums[i] = w--;
            } else {
                nums[i] = b--;
            }
        }
    }
}
