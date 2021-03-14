package com.eric.offerdemo;

/**
 * 在排序数组中查找数字I
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author：hanzhigang
 * @Date : 2021/3/14 11:01 PM
 */
public class OfferDemo53 {

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
//      如果数组为空，或者是target不在nums数组中返回0
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return 0;
        }
//        return binarySearch(nums, 0, nums.length - 1, target);
//      即target在数组中的右边界减去target-1在数组中的右边界！！！
        return helper(nums,target) - helper(nums,target-1);
    }

    public int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
//      如果左索引大于右索引返回0
        if (startIndex > endIndex) {
            return 0;
        }
        int mid = startIndex + (endIndex - startIndex) / 2;
        if (nums[mid] == target) {
            return 1 + binarySearch(nums, startIndex, mid - 1, target) + binarySearch(nums, mid + 1, endIndex, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, endIndex, target);
        } else {
            return binarySearch(nums, startIndex, mid - 1, target);
        }
    }

    //  寻找target在数组中的右边界
    public int helper(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

}
