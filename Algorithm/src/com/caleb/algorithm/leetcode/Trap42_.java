package com.caleb.algorithm.leetcode;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author：hanzhigang
 * @Date : 2021/4/6 9:26 PM
 */
public class Trap42_ {
    public int trap(int[] height) {
        // 数组为空，返回0
        if(height.length == 0){
            return 0;
        }
        int maxHeiIndex = 0;    // 记录高度最高的下标
        int[] res = new int[height.length];
        res[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= height[i - 1]) {   // 如果当前比前一个高度小，则存不了水
                res[i] = res[i - 1];
            } else {    // 当前高度比上一个高，则与之前高度最高的比较，计算两者之间的最小高度总和，然后减去两者之间存在的高度，加上res[maxHeiIndex]就是截止到当前位置能够存的水
                int left = 0;   // 记录两者之间存在的高度
                for (int start = i - 1; start > maxHeiIndex; start--) {
                    left += Math.min(height[start], height[i]);
                }
                System.out.println(left);
                res[i] = res[maxHeiIndex] + ((i - maxHeiIndex - 1) * Math.min(height[i], height[maxHeiIndex])) - left;
                if (height[i] >= height[maxHeiIndex]) {
                    maxHeiIndex = i;
                }
            }
        }
        return res[height.length - 1];
    }

    public static void main(String[] args) {
        int[] res = new int[]{9,6,8,8,5,6,3};
        Trap42_ trap42 = new Trap42_();
        System.out.println(trap42.trap(res));
    }
}
