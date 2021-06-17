package com.caleb.algorithm.leetcode;

import java.util.Stack;

/**
 * 柱状图中的最大矩阵 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。 单调栈 思想：单调递增栈，栈中存放的是数组中最小的数，当出现更小的数时，以栈顶元素为最高高度的矩形面积为
 * （即将入栈的下标 - 栈顶元素的下一个元素的下标/-1）* 栈顶元素的高度
 * 
 * @author：caleblogin
 * @Date : 2021/4/15 5:33 PM
 */
public class LargestRectangleArea84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int topIndex, peekIndex;
        int max = 0;
        Stack<Integer> stack = new Stack();
        stack.add(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                topIndex = stack.pop();
                if (!stack.isEmpty()) {
                    peekIndex = stack.peek();
                } else {
                    // 当栈中不再有元素时，说明当前遍历过的元素中，当前元素是最小元素，以当前元素为最大高度的矩形面积为（即将入栈元素的下标 + 1）* 当前元素的高度
                    peekIndex = -1;
                }
                int currHei = heights[topIndex] * (i - peekIndex - 1);
                max = Math.max(max, currHei);
            }
            stack.add(i);
        }
        while (!stack.isEmpty() && heights[stack.peek()] > 0) {
            topIndex = stack.pop();
            if (!stack.isEmpty()) {
                peekIndex = stack.peek();
            } else {
                peekIndex = -1;
            }
            int currLen = peekIndex == -1 ? len : (len - peekIndex - 1);
            int currHei = heights[topIndex] * currLen;
            max = Math.max(max, currHei);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleArea84 l = new LargestRectangleArea84();
        System.out.println(l.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
    }

}
