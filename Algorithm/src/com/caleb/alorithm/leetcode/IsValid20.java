package com.caleb.alorithm.leetcode;

import java.util.LinkedList;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 11:52 PM
 */
public class IsValid20 {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        LinkedList<Character> linkedList = new LinkedList<>();
        for (Character c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                linkedList.addLast(c);
            } else {
                if (linkedList.isEmpty()) {
                    return false;
                } else {
                    Character cp = linkedList.pollLast();
                    switch (c) {
                        case ')':
                            if (cp != '(') return false;
                            break;
                        case ']':
                            if (cp != '[') return false;
                            break;
                        case '}':
                            if (cp != '{') return false;
                            break;
                    }
                }
            }
        }

        return linkedList.isEmpty() ? true:false;
    }
}
