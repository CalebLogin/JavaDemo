package com.caleb.alorithm.leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * @author：hanzhigang
 * @Date : 2021/4/6 7:40 PM
 */
public class SearchRange34 {

    /**
     * 二分查找的想法，找到target，前后遍历
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int startIndex = -1;
        int endIndex = -1;
        int mid = 0;

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            mid = l + ((r - l) >> 2);
            if (nums[mid] == target) {
                int lmid = mid;
                int rmid = mid;
                while (lmid >= 0 && nums[lmid] == target) lmid--;
                while (rmid < nums.length && nums[rmid] == target) rmid++;
                startIndex = ++lmid;
                endIndex = --rmid;
                break;
            }

            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            }
        }
        return new int[]{startIndex, endIndex};
    }

    public static void main(String[] args) {
        SearchRange34 searchRange34 = new SearchRange34();
        int[] res = searchRange34.searchRange(new int[]{}, 0);
        System.out.println("["+res[0]+","+res[1]+"]");
    }
}
