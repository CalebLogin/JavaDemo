package com.eric.alorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 全排列，然后挑选
 * 思路：某一状态下，使用'('的个数要大于或等于使用')'的个数
 * @author：hanzhigang
 * @Date : 2021/4/4 7:35 PM
 */
public class GenerateParenthesis22 {

    char[] sc;  // 存放符合条件的字符
    List<String> res = new ArrayList<>();
    int leftSum, rightNum;    // 记录'('的个数

    /**
     * 回溯版本
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        // 返回字符串的长度，也是回溯中栈的深度
        int depth = n * 2;
        sc = new char[depth];

        leftSum = n;
        rightNum = n;
        helper(leftSum, rightNum, n*2-1);
        return res;

    }

    public void helper(int leftSum, int rightNum, int depth) {
        if (leftSum == 0 && rightNum == 0) {
            res.add(String.valueOf(sc));
            return;
        }
        if (leftSum < rightNum) {
            return;
        }
        if (leftSum > 0) {
            sc[depth] = '(';
            helper(leftSum-1,rightNum,depth-1);
        }
        if (rightNum > 0) {
            sc[depth] = ')';
            helper(leftSum,rightNum-1,depth-1);
        }

    }



    public static void main(String[] args) {
        GenerateParenthesis22 generateParenthesis22 = new GenerateParenthesis22();
        List<String> list = generateParenthesis22.generateParenthesis(3);
        for (String str : list) {
            System.out.print(str + "--");
        }
    }

}
