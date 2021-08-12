package com.caleb.algorithm.leetcode;

/**
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间
 *
 * @author：hanzhigang
 * @Date : 2021/6/7 12:30 AM
 */
public class FindDuplicate287 {
    /**
     * 原地置换的思想
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        return 0;
    }

    /**
     * 当数组前半段不存在重复值的时候，
     * 整个数组小于mid的个数是小于等于一半的，反之大于一半
     *
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int cnt = 0;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
            cnt = 0;
        }
        return ans;
    }

    /**
     * 二进制
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int bitMax = 31;
        while (((n - 1) >> bitMax) == 0) {
            bitMax -= 1;
        }
        for (int b = 0; b <= bitMax; b++) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                /**
                 * 寻找nums数组中所有数在第b位一共有多少个1
                 */
                if ((nums[i] & (1 << b)) != 0) {
                    x++;
                }
                /**
                 * 寻找1～n在第b位一共有多少个1
                 */
                if (i >= 1 && (i & (1 << b)) != 0) {
                    y++;
                }
            }
            /**
             * 如果数组中所有数在第b位出现1的个数大于1～n在第b位出现1的个数
             * 说明出现重复值，将当前b位的1记录下来
             */
            if (x > y) {
                ans |= (1 << b);
            }
        }
        return ans;
    }

    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (fast != slow);
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        FindDuplicate287 findDuplicate287 = new FindDuplicate287();
        System.out.println(findDuplicate287.findDuplicate2(new int[]{1, 3, 4, 2, 2}));
    }
}
