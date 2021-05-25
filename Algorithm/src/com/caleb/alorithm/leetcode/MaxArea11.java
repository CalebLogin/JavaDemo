package com.eric.alorithm.leetcode;

/**
 * 盛最多的水
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * @author：hanzhigang
 * @Date : 2021/4/1 9:12 PM
 */
public class MaxArea11 {
    public int maxArea(int[] height) {
        int max = 0;
        int cur = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            cur = Math.min(height[left],height[right]) * (right-left);
            max = Math.max(cur,max);
            // 移动高度小的一边
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4, 3, 2, 1, 4};
        MaxArea11 maxArea11 = new MaxArea11();
        System.out.println(maxArea11.maxArea(height));
    }
}
