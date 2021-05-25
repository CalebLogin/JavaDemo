package com.caleb.offerdemo;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * @author：hanzhigang
 * @Date : 2021/3/2 11:14 AM
 */
public class OfferDemo09 {
    public static void main(String[] args) {
    }
}

class CQueue {

//  建立两个栈用来实现队列,stack1作为输入栈，stack2作出输出栈
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }else{
            return stack2.pop();
        }
    }
}
