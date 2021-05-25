package com.caleb.offerdemo;

/**
 * 连续子数组的最大和
 * @author：hanzhigang
 * @Date : 2021/3/11 9:50 PM
 */
public class OfferDemo42 {

    /**
     * 动态规划的方法 dp[i+1] = max(dp[i]+cur,cur)
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = dp[0];
        for(int num:dp){
            if(num>max){
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
