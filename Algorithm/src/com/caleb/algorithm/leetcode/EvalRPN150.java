package com.caleb.algorithm.leetcode;

import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * @author：hanzhigang
 * @Date : 2021/4/27 11:33 PM
 */
public class EvalRPN150 {

    /**
     * 栈的思想
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0;i<tokens.length;i++){
            String tmp = tokens[i];
            if(!tmp.equals("*") && !tmp.equals("/") && !tmp.equals("+") && !tmp.equals("-")){
                stack.offerLast(Integer.parseInt(tmp));
            }else{
                int l = 0;
                int r = 0;
                System.out.println(stack.size());
                r = stack.pollLast();
                l = stack.pollLast();
                if(tmp.equals("*")){
                    stack.offerLast(l * r);
                }else if(tmp.equals("/")){
                    stack.offerLast(l / r);
                }else if(tmp.equals("+")){
                    stack.offerLast(l + r);
                }else{
                    stack.offerLast(l - r);
                }
            }
        }
        return stack.pollLast();
    }

    public static void main(String[] args) {
        EvalRPN150 evalRPN150 = new EvalRPN150();
        String[] strs = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN150.evalRPN(strs));
    }
}
