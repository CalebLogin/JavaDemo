package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串相乘 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * @author:Caleb
 * @Date :2021-06-21 22:39:28
 */
public class Multiply43_ {

	/**
	 * 普通竖式
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")){
			return "0";
		}
		List<Character> list = new ArrayList<>();
		int multiplier = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			multiplier = 0;
			for (int j = num2.length() - 1; j >= 0; j--) {
				int res = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int addRes = res + multiplier;
				int index = num1.length() + num2.length() - i - j - 2;
				if (index == list.size()) {
					list.add((char) ((addRes % 10) + '0'));
					multiplier = addRes / 10;
				} else {
					multiplier = (addRes + (list.get(index) - '0')) / 10;
					list.set(index, (char) ((addRes + (list.get(index) - '0')) % 10 + '0'));
				}
			}
			if (multiplier != 0) {
				list.add((char) (multiplier + '0'));
			}
		}
		StringBuffer stringBuffer = new StringBuffer();
		int i = 0,j = list.size()-1;
		for (;j>=i;j--) {
			stringBuffer.append(list.get(j));
		}
		return stringBuffer.toString();
	}
	/**
	 * 优化竖式
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply1(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")){
			return "0";
		}
		int[] res = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			for (int j = num2.length() - 1; j >= 0; j--) {
				int n2 = num2.charAt(j) - '0';
				int sum = (res[i+j+1] + n1 * n2);
				res[i+j+1] = sum % 10;
				res[i+j] += sum / 10;
			}
		}
		StringBuffer resStr = new StringBuffer();
		for(int i = 0;i<res.length;i++){
			if(i == 0 && res[i] == 0) {
				continue;
			}
			resStr.append(res[i]);
		}
		return resStr.toString();

	}

	public static void main(String[] args) {
		Multiply43_ multiply43 = new Multiply43_();
		System.out.println(multiply43.multiply("123", "0"));
	}

}