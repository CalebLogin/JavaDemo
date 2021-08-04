package com.caleb.algorithm.review.offerdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-08-04 18:16:39
 */
public class Permutation38 {

	Set<String> res = new HashSet<>();

	public String[] permutation(String s) {
		char[] cs = s.toCharArray();
		dfs(cs, 0);
		return new ArrayList<>(res).toArray(new String[0]);
	}

	private void dfs(char[] cs, int start) {
		if(start == cs.length - 1){
			
		}
		for (int i = start; i < cs.length; i++) {
			swap(cs, start, i);
			res.add(new String(cs));
			dfs(cs, start + 1);
			swap(cs, start, i);
		}
	}

	private void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

}