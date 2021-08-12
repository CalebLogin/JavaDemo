package com.caleb.algorithm.leetcode;

/**
 * 有效数字 有效数字（按顺序）可以分成以下几个部分： 1.一个 小数 或者 整数 2.（可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分： 1.（可选）一个符号字符（'+' 或 '-'） 下述格式之一： 1.至少一位数字，后面跟着一个点 '.'
 * 2.至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 3.一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：1.（可选）一个符号字符（'+' 或 '-'） 2.至少一位数字 部分有效数字列举如下： ["2", "0089",
 * "-0.1", "+3.14","4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93",
 * "-123.456e789"] 部分无效数字列举如下： ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3",
 * "95a54e53"] 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * 
 * @author:Caleb
 * @Date :2021-06-17 09:16:26
 */
public class IsNumber65 {

	public boolean isNumber(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() == 1 && s.charAt(0) == '.') {
			return false;
		}

		// 是否包含小数点
		boolean hasPoint = false;
		// 小数点在字符串中的位置
		int pointIndex = -1;
		boolean hasE = false;
		int eIndex = -1;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				// 如果出现多个小数点，返回false
				if (hasPoint) {
					return false;
				}
				pointIndex = i;
				hasPoint = true;
			}
			if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
				// 出现多个e，返回false
				if (hasE) {
					return false;
				}
				eIndex = i;
				hasE = true;
			}
			// 如果出现其他字符，返回false
			if (!(Character.isDigit(s.charAt(i)) || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '.'
					|| s.charAt(i) == 'E' || s.charAt(i) == 'e')) {
				return false;
			}
		}
		if (hasE) {
			// e的前缀是否合法
			boolean isPrefixValid = hasPoint ? isValidPoint(s, 0, eIndex, pointIndex) : isInteger(s, 0, eIndex);
			return isPrefixValid && isInteger(s, eIndex + 1, s.length());
		}
		if (hasPoint) {
			return isValidPoint(s, 0, s.length(), pointIndex);
		}
		return isInteger(s, 0, s.length());
	}

	/**
	 * 小数是否合法
	 * @param s
	 * @param start
	 * @param end
	 * @param pos
	 * @return
	 */
	private boolean isValidPoint(String s, int start, int end, int pos) {
		if (s.charAt(start) == '+' || s.charAt(start) == '-') {
			start++;
			if (start + 1 == end) {
				return false;
			}
		}
		for(int i = start ; i<end;i++){
			if(s.charAt(i) != '.' && !Character.isDigit(s.charAt(i))){
				return false;
			}
		}
		return isInteger(s, start, pos) || isInteger(s, pos + 1, end);

	}

	/**
	 * 判断是不是整数
	 * 
	 * @param s
	 * @return
	 */
	private boolean isInteger(String s, int start, int end) {
		if (start >= end) {
			return false;
		}
		if (s.charAt(start) == '+' || s.charAt(start) == '-') {
			start++;
			if (start == end) {
				return false;
			}
		}
		for (int i = start; i < end; i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		IsNumber65 isNumber65 = new IsNumber65();
		String[] strs = new String[] { "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
				"53.5e93", "-123.456e789" };
		String[] strs1 = new String[] { "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53" };
		for (String str : strs1) {
			System.out.println(isNumber65.isNumber(str));
		}
		for (String str : strs) {
			System.out.println(isNumber65.isNumber(str));
		}
		System.out.println(isNumber65.isNumber("."));
		System.out.println(isNumber65.isNumber(".e1"));
		System.out.println(isNumber65.isNumber("4e+"));
		System.out.println(isNumber65.isNumber("+."));
		System.out.println(isNumber65.isNumber("5.-"));
	}

}