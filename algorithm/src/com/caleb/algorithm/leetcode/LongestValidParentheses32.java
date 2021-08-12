package com.caleb.algorithm.leetcode;

import java.util.Stack;

/**
 * @author:Caleb
 * @Date :2021-07-06 22:24:06
 * 
 *       最长有效括号
 * 
 *       给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LongestValidParentheses32 {

	/**
	 * 栈的思想
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return 0;
		}
		int maxCount = 0;
		int right = 0; // 遍历s的指针
		Stack<Integer> stack = new Stack<>();
		stack.add(-1);

		while (right < s.length()) {
			// 如果即将进栈的是右括号，并且栈顶是左括号，这两个可成为一对，记录到sAvail中
			if (s.charAt(right) == '(') {
				stack.add(right);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.add(right);
				} else {
					maxCount = Math.max(maxCount, right - stack.peek());
				}
			}
			right++;
		}
		return maxCount;
	}

	/**
	 * 统计左括号和右括号的个数
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses1(String s) {
		int leftCount = 0; // 左括号的个数
		int rightCount = 0; // 右括号的个数
		int maxCount = 0; // 最多个数
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftCount++;
			} else {
				rightCount++;
			}
			if (rightCount > leftCount) {
				leftCount = 0;
				rightCount = 0;
			}
			if (leftCount == rightCount) {
				maxCount = Math.max(maxCount, leftCount + rightCount);
			}
		}
		leftCount = 0;
		rightCount = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				leftCount++;
			} else {
				rightCount++;
			}
			if (leftCount > rightCount) {
				leftCount = 0;
				rightCount = 0;
			}
			if (leftCount == rightCount) {
				maxCount = Math.max(maxCount, leftCount + rightCount);
			}
		}
		return maxCount;
	}

	/**
	 * 动态规划的思想
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses2(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return 0;
		}
		int maxCount = 0;
		int[] dp = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			/**
			 * 如果当前字符为右括号，分两种情况
			 * 
			 * 1. 前一个字符是左括号，dp[i] = dp[i-2] + 1
			 * 
			 * 2. 前一个括号是右括号，1）如果前一个右括号有相应匹配的，则向前寻找与之能匹配的左括号。
			 * 
			 * dp[i] = dp[i-dp[i-1]-1] == '(' ? dp[i-1] + 2 : 0
			 * 此时，这可能是一个独立的括号，需要和前面的括号相加。dp[i] += dp[i-dp[i-1]-2]
			 */
			if (s.charAt(i) == ')') {
				if (dp[i - 1] == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxCount = Math.max(maxCount, dp[i]);
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		LongestValidParentheses32 l = new LongestValidParentheses32();
		System.out.println(l.longestValidParentheses2("))))((()(("));
	}

}