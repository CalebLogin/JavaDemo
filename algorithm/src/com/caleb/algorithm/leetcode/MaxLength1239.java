package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 串联字符串的最大长度
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，
 * 如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 请返回所有可行解 s 中最长长度。
 * @author:Caleb
 * @Date :2021-06-19 09:36:17
 */
public class MaxLength1239 {

	int count = 0;
	int maxCount = 0;


	/**
	 * 方法1
	 * @param arr
	 * @return
	 */
	public int maxLength(List<String> arr) {
		int[] flags = new int[26];
		List<String> afterProcessed = new ArrayList<>();
		for(String str: arr){
			Arrays.fill(flags, 0);
			int j = 0;
			for(;j<str.length();j++){
				if(flags[str.charAt(j)-'a'] != 0){
					break;
				}else{
					flags[str.charAt(j)-'a'] = 1;
				}
			}
			if(j == str.length()){
				afterProcessed.add(str);
			}
		}
		int len = afterProcessed.size();
		int[] strToBinary = new int[len];
		for (int i = 0;i<len;i++) {
			for (int j = 0; j < afterProcessed.get(i).length(); j++) {
				strToBinary[i] |= (1 << (afterProcessed.get(i).charAt(j) - 'a'));
			}
		}
		maxLengthHelper(strToBinary, 0, 0);
		return maxCount;
	}

	public void maxLengthHelper(int[] strToBinary, int start,int targetNum){
		if(start == strToBinary.length){
			
			return;
		}
		for(int i = start;i<strToBinary.length;i++){
			if((targetNum & strToBinary[i]) == 0){
				count+=Integer.bitCount(strToBinary[i]);
				maxCount = Math.max(maxCount, count);
				maxLengthHelper(strToBinary, i+1, (targetNum | strToBinary[i]));
				count-=Integer.bitCount(strToBinary[i]);
			}
		}
	}

	public static void main(String[] args) {
		MaxLength1239 m = new MaxLength1239();
		List<String> arr = new ArrayList<>();
		arr.add("yy");
		arr.add("bkhwmpbiisbldzknpm");
		System.out.println(m.maxLength(arr));
	}

}