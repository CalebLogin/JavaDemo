package com.caleb.algorithm.leetcode;

/**
 * 搜索排序数组II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * @author：hanzhigang
 * @Date : 2021/4/7 8:33 PM
 */
public class Search81 {

    // 朴素算法
    public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search1(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[r] == nums[mid]) {
                --r;
                ++l;
            } else if (nums[l] <= nums[mid]) {  // 处于非递减队列中
                if (nums[l] <= target && target < nums[mid]) {  // 如果target值位于非递减队列中，向左收敛，否则直接向右收敛，将问题抛给下个else
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {  // 处于旋转队列中
                if (nums[mid] < target && target <= nums[n - 1]) {  // 如果target值位于旋转队列中的非递减队列中，向右收敛，否则将问题抛给上面的else if
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public boolean search2(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        // 主要为了解决前面一部分的值与后面一部分的值相同，导致无法判断该往前遍历还是往后遍历的问题，
        // 如[1,1,1,1,3,1,1] [1,1,1,1,0,1,1]
        // 恢复二段性
        while (l <= r && nums[l] == nums[r]) {
            r--;
        }
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] <= nums[mid]) {   // 处于非递减队列中
                if (nums[l] <= target && target < nums[mid]) {
                    mid--;
                    while (mid > l && nums[mid] == nums[mid + 1]) {
                        mid--;
                    }
                    r = mid;
                } else {
                    mid++;
                    while (mid < r && nums[mid] == nums[mid - 1]) {
                        mid++;
                    }
                    l = mid;
                }
            }else {
                if (nums[mid] < target && nums[n - 1] >= target) {
                    mid++;
                    while (mid < r && nums[mid] == nums[mid - 1]) {
                        mid++;
                    }
                    l = mid;
                } else {
                    mid--;
                    while (mid > l && nums[mid] == nums[mid + 1]) {
                        mid--;
                    }
                    r = mid;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search81 search81 = new Search81();
        System.out.println(search81.search1(new int[]{1, 1, 1, 1, 3, 1, 1}, 3));
    }


}
