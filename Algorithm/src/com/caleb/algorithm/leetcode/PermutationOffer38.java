package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @author:Caleb
 * @Date :2021-06-22 11:50:45
 */
public class PermutationOffer38 {
	List<String> res = new ArrayList<>();

	public String[] permutation(String s) {
		char[] cs = s.toCharArray();
		permutationHelper(cs, 0, cs.length);
		return res.toArray(new String[res.size()]);
	}

	private void permutationHelper(char[] cs, int start, int end) {

		if (start == end - 1) {
			res.add(String.valueOf(cs));
			return;
		}
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			if(set.contains(cs[i])) continue; // 剪枝
			set.add(cs[i]);
			swap(cs, i, start);
			permutationHelper(cs, start + 1, end);
			swap(cs, i, start);
		}
	}

	private void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

	public static void main(String[] args) {
		PermutationOffer38 p = new PermutationOffer38();
		String[] strs = p.permutation("aabc");
		for (String str : strs) {
			System.out.println(str);
		}
	}

}