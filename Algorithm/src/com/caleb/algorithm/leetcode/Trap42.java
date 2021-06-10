package com.caleb.algorithm.leetcode;

import java.util.Stack;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author：hanzhigang
 * @Date : 2021/4/6 9:26 PM
 */
public class Trap42 {

    /**
     * 暴力解法
     *
     * @param height
     * @return
     */
    private int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    /**
     * 备忘录的方法
     *
     * @param height
     * @return
     */
    private int trap1(int[] height) {
        int ans = 0;
        int size = height.length;
        if (size <= 2) {
            return 0;
        }
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        rightMax[size - 1] = height[size - 1];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 单调栈的想法
     *
     * @param height
     * @return
     */
    private int trap2(int[] height) {
        int ans = 0;
        int size = height.length;
        if (size <= 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int l = 0;
        // curr 始终指向栈顶
        int curr = 0;
        int r = 0;
        for (int i = 0; i < size; i++) {
            r = i;
            // 当不再符合单调递减的情况时，当前即将进栈的与栈内的一一比较
            // 当栈顶的两个元素不相等时，栈顶的元素能够存放的水等于
            // （即将进栈的高度与第二个栈顶的高度的最小值-栈顶元素的高度） * 即将进栈的元素与栈顶元素之间的距离
            while (!stack.isEmpty() && height[stack.peek()] < height[r]) {
                curr = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                l = stack.peek();
                int h = Math.min(height[l], height[r]) - height[curr];
                ans += (r - l - 1) * h;
                System.out.println("ans  " + ans);
            }
            stack.add(r);
        }
        return ans;
    }

    /**
    * 双指针
    **/
    public int trap3(int[] height) {
        int size = height.length;
        int ans = 0;
        if (size <= 2) {
            return 0;
        }
        int left = 0, right = size - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if(height[left] < height[right]){
                if(height[left] > leftMax){
                    leftMax = height[left];
                }else{
                    ans += (leftMax - height[left]);
                }
                left++;
            }else{
                if(height[right] > rightMax){
                    rightMax = height[right];
                }else{
                    ans += (rightMax - height[right]);
                }
                right--;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] res = new int[] {9, 6, 8, 8, 5, 6, 3};
        Trap42 trap42 = new Trap42();
        System.out.println(trap42.trap(res));
    }
}
