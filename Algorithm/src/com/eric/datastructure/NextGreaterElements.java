package com.eric.datastructure;

import java.util.Arrays;
import java.util.Stack;

/**
 * 下一个更大的元素 503
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *
 * @author：hanzhigang
 * @Date : 2021/3/7 11:10 AM
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int numLength = nums.length;
//      返回结果数组
        int[] res = new int[numLength];
//      定义单调栈，栈中元素单调不升。
//      进栈元素与栈顶元素比较，进栈元素大于栈顶元素，则栈顶元素弹出，一直到栈顶元素大于进栈元素为止。
//      若进栈元素小于栈顶元素，则进栈
        Stack<Integer> stack = new Stack<>();
//      将返回结果数组填充-1
        Arrays.fill(res, -1);
        int length = numLength * 2;
        stack.add(0);
        for (int i = 1; i < length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % numLength]) {
                int num = stack.pop();
                res[num] = nums[i % numLength];
            }
            stack.add(i % numLength);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElements nextGreaterElements = new NextGreaterElements();
        System.out.println(nextGreaterElements.nextGreaterElements(new int[]{5,4,3,2,1})[2]);
    }
}
