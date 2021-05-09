package com.eric.alorithm.leetcode;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @author：hanzhigang
 * @Date : 2021/5/10 12:00 AM
 */
public class Rob198 {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] res = new int[nums.length + 3];
        for (int i = 3; i < nums.length + 3; i++) {
            // 比较前2和前3的最大值
            res[i] = Math.max(res[i - 2], res[i - 3]) + nums[i - 3];
        }
        return Math.max(res[nums.length + 2], Math.max(res[nums.length + 1], res[nums.length]));
    }

    public int rob1(int[] nums) {
        int len = nums.length;

        if (nums.length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        /**
         * 站在第二家，可以选择1或者2
         * 之后，可以选择不劫，也可以选择劫
         * 就要看前1和（前2+当前的）那个大，不劫钱多，就选择不劫，劫钱多，就选择劫
         * 偷还是不偷，这是一个问题
         */
        for (int i = 2; i < len; i++) {
            int temp = Math.max(first + nums[i], second);
            first = second;
            second = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        Rob198 rob198 = new Rob198();
        System.out.println(rob198.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
