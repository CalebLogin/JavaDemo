package com.caleb.offerdemo;

/**
 * 0~n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * @Date : 2021/3/15 9:02 PM
 */
public class OfferDemo53_II {
    /**
     * 思路1：二分查找
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int i = 0,j=nums.length;
//      通过二分法找到缺失的位置
        while(i<j){
            int mid = i+(j-i)/2;
            if(nums[mid] == mid){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
