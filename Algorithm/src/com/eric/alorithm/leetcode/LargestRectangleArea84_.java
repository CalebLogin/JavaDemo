package com.eric.alorithm.leetcode;

/**
 * 柱状图中的最大矩阵
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @author：hanzhigang
 * @Date : 2021/4/15 5:33 PM
 */
public class LargestRectangleArea84_ {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int l = 0, r = n - 1; // 双指针，指向当前矩阵
        int max = 0;    // 记录最大值
        while (l <= r) {
            max = Math.max(Math.min(heights[l], heights[r]) * (r - l + 1), max);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
