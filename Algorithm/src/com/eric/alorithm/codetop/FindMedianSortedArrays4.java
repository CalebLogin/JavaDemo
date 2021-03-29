package com.eric.alorithm.codetop;

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
        if(nums1.length == 0){
            return median(nums2);
        }else if(nums2.length == 0){
            return median(nums1);
        }
        int startNums1 = 0, startNums2 = 0;
        while(startNums1 < nums1.length && startNums2 < nums2.length && startNums1+startNums2 < (nums1.length+nums2.length)/2){
            if(nums1[startNums1] < nums2[startNums2]){
                startNums1++;
            }else{
                startNums2++;
            }
        }
        return

    }
    public double median(int [] nums){
        return (nums.length & 1) == 1 ? (double)nums[nums.length/2] : (nums[nums.length/2] + nums[(nums.length/2)+1])/ 2.0;
    }
}
