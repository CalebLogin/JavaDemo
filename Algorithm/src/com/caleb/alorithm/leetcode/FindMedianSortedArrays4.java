package com.caleb.alorithm.leetcode;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 思路：寻找中位数
 * 当nums1的中位数比nums2的中位数小时，中位数位于nums1的后半段和nums2的前半段
 * 当nums1的中位数比nums2的中位数大时，中位数位于nums1的前半段和nums2的后半段
 *
 * @author：hanzhigang
 * @Date : 2021/3/28 10:44 PM
 */
public class FindMedianSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 某一个数组为空，返回另一个数组的中位数
        if (nums1.length == 0) {
            return median(nums2);
        } else if (nums2.length == 0) {
            return median(nums1);
        }

        // 当两个数组和为偶数时，先计算两个中位数的前一个，如果为奇数直接计算
        int len = nums1.length + nums2.length;
        // k=1 表示某个数组中该下标的数是中位数或者是中位数的一部分
        int k = (len & 1) == 1 ? len / 2 + 1 : len / 2;
        int curK = k / 2 - 1;
        // 两个数组的遍历下标
        int s1 = 0, s2 = 0;

        while (s1 < nums1.length && s2 < nums2.length && k != 1) {
            // 如果当前数组下标加上curK超出数组长度，仅比较当前数组的最大下标和另一个数组的下标+curK
            if (s1 + curK >= nums1.length) {
                if (nums1[nums1.length - 1] <= nums2[s2 + curK]) {
                    curK = nums1.length - s1;
                    s1 = nums1.length;
                    k -= curK;
                    break;
                } else {
                    s2 += curK + 1;
                    curK = k - k / 2;
                    k = curK;
                    curK = k / 2 - 1;
                    continue;
                }
            }

            if (s2 + curK >= nums2.length) {
                if (nums2[nums2.length - 1] <= nums1[s1 + curK]) {
                    curK = nums2.length - s1;
                    s2 = nums2.length;
                    k -= curK;
                    break;
                } else {
                    s1 += curK + 1;
                    curK = k - k / 2;
                    k = curK;
                    curK = k / 2 - 1;
                    continue;
                }
            }

            // 在没有数组越界的情况下继续比较
            if (nums1[s1 + curK] < nums2[s2 + curK]) {
                s1 += curK + 1;
            } else {
                s2 += curK + 1;
            }
            curK = k - k / 2;
            k = curK;
            curK = k / 2 - 1;
        }

        // 数组越界的情况
        if (s1 == nums1.length) {
            return (len & 1) == 1 ? nums2[s2 + k - 1] : (nums2[s2 + k - 1] + nums2[s2 + k]) / 2.0;
        }
        if (s2 == nums2.length) {
            return (len & 1) == 1 ? nums1[s1 + k - 1] : (nums1[s1 + k - 1] + nums1[s1 + k]) / 2.0;
        }

        // 得到最小值
        int min = Math.min(nums1[s1], nums2[s2]);
        int min1 = 0;
        // 当数组和是奇数时，仅返回min
        if ((len & 1) == 1) return min;
        // 当数组和是偶数时，计算出下一个小的数值
        if (min == nums1[s1]) {
            ++s1;
            // 当前数组出现数组越界
            if (s1 == nums1.length) {
                min1 = nums2[s2];
            } else {
                min1 = Math.min(nums1[s1], nums2[s2]);
            }
        } else {
            ++s2;
            // 当前数组出现数组越界
            if (s2 == nums2.length) {
                min1 = nums1[s1];
            } else {
                min1 = Math.min(nums1[s1], nums2[s2]);
            }
        }
        return (min + min1) / 2.0;
    }

    // 返回当前数组的中位数
    public double median(int[] nums) {
        return (nums.length & 1) == 1 ? (double) nums[nums.length / 2] : (nums[nums.length / 2 - 1] + nums[(nums.length / 2)]) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2, 3, 4};
        FindMedianSortedArrays4 findMedianSortedArrays4 = new FindMedianSortedArrays4();
        System.out.println(findMedianSortedArrays4.findMedianSortedArrays(nums1, nums2));
    }
}
