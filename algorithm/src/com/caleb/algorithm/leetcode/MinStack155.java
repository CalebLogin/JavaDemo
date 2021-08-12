package com.caleb.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 思路：单调栈
 * @author：hanzhigang
 * @Date : 2021/5/7 10:14 PM
 */
public class MinStack155 {

}
class MinStack {

    Deque<Integer> s;
    Deque<Integer> minS;
    public MinStack() {
        s = new LinkedList<>();
        minS = new LinkedList<>();
    }

    public void push(int val) {
        s.push(val);
        if(minS.isEmpty() || minS.peek() >= val){
            minS.push(val);
        }
    }

    public void pop() {
        if(s.pop().equals(minS.peek())){
            minS.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
