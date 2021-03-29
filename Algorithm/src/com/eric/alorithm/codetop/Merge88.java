package com.eric.alorithm.codetop;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 11:54 PM
 */
public class Merge88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numTotal = new int[m * n];
        int num1Index = 0, num2Index = 0, curIndex = 0;
        while (num1Index < m && num2Index < n) {
            if (nums1[num1Index] < nums2[num2Index]) {
                numTotal[curIndex++] = nums1[num1Index++];
            } else {
                numTotal[curIndex++] = nums2[num2Index++];
            }
        }
        while (num1Index < m) {
            numTotal[curIndex++] = nums1[num1Index++];
        }
        while (num2Index < n) {
            numTotal[curIndex++] = nums1[num2Index++];
        }
        for (int i = 0; i < m * n; i++) {
            nums1[i] = numTotal[i];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int num1Index = m - 1, num2Index = m - 1, curIndex = m + n - 1;
        while (num1Index >= 0 && num2Index >= 0) {
            if (nums1[num1Index] > nums2[num2Index]) {
                nums1[curIndex--] = nums1[num1Index--];
            } else {
                nums1[curIndex--] = nums2[num2Index--];
            }
        }
        while (num1Index >= 0) {
            nums1[curIndex--] = nums1[num1Index--];
        }
        while (num2Index >= 0) {
            nums1[curIndex--] = nums1[num2Index--];
        }
    }


}
