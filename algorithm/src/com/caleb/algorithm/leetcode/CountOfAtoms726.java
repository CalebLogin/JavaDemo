package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author:Caleb
 * @Date :2021-07-05 09:10:17
 * 
 *       原子的数量 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * 
 *       原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * 
 *       如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2
 *       这个表达是不可行的。
 * 
 *       两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * 
 *       一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * 
 *       给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于
 *       1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推
 * 
 *       输入: formula = "H2O" 输出: "H2O" 解释: 原子的数量是 {'H': 2, 'O': 1}。
 * 
 */
public class CountOfAtoms726 {

	public String countOfAtoms(String formula) {
		Map<String, Integer> res = countOfAtoms(formula, 0, formula.length() - 1);
		Map<String,Integer> sortedMap = new TreeMap<>((o1,o2)->o1.compareTo(o2));
		StringBuilder s = new StringBuilder();
		sortedMap.putAll(res);
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			if(entry.getValue() !=1){
				s.append(entry.getKey() + "" + entry.getValue());
			}else{
				s.append(entry.getKey());
			}
			
		}
		return s.toString();
	}

	private Map<String, Integer> countOfAtoms(String formula, int left, int right) {
		if (left > right) {
			return new HashMap<>();
		}
		Map<String, Integer> res = new HashMap<>();
		int leftPre = left, leftNext = left, rightPre = right, rightNext = right;
		while (leftNext <= right && formula.charAt(leftNext) != '(') {
			leftNext++;
		}
		while (rightNext >= left && formula.charAt(rightNext) != ')') {
			rightNext--;
		}
		if (leftNext < rightNext) {
			Map<String, Integer> sub = countOfAtoms(formula, leftNext + 1, rightNext - 1);
			if (rightNext < rightPre && Character.isDigit(formula.charAt(rightNext + 1))) {
				rightNext++;
				int rightTemp = rightNext;
				while (rightNext <= rightPre && Character.isDigit(formula.charAt(rightNext))) {
					rightNext++;
				}
				int count = Integer.parseInt(formula.substring(rightTemp, rightNext));
				for (String key : sub.keySet()) {
					sub.put(key, sub.get(key) * count);
				}
			}
			res.putAll(sub);
			for(Map.Entry<String, Integer> entry: getAtomsCount(formula.substring(leftPre, leftNext)).entrySet()){
				res.put(entry.getKey(), res.getOrDefault(entry.getKey(), 0) + entry.getValue());
			}
			for(Map.Entry<String, Integer> entry: getAtomsCount(formula.substring(rightNext, rightPre + 1)).entrySet()){
				res.put(entry.getKey(), res.getOrDefault(entry.getKey(), 0) + entry.getValue());
			}
		} else {
			res.putAll(getAtomsCount(formula.substring(leftPre, rightPre + 1)));
		}
		System.out.println(res.toString());
		return res;
	}

	/**
	 * 统计没有括号的字符串中原子的个数
	 * 
	 * @param formula
	 * @return
	 */
	private Map<String, Integer> getAtomsCount(String formula) {
		if(formula.equals("")){
			return new HashMap<>();
		}
		Map<String, Integer> res = new HashMap<>();
		int left = 0, right = 0;
		while (right < formula.length() && left <= right) {
			if (Character.isUpperCase(formula.charAt(right))) {
				if (left != right) {
					res.put(formula.substring(left, right), res.getOrDefault(formula.substring(left, right), 0) + 1);
					left = right;
				}
			} else if (Character.isDigit(formula.charAt(right))) {
				int rightTemp = right;
				while (right < formula.length() && Character.isDigit(formula.charAt(right))) {
					right++;
				}
				int count = Integer.parseInt(formula.substring(rightTemp, right));
				res.put(formula.substring(left, rightTemp),
						res.getOrDefault(formula.substring(left, rightTemp), 0) + count);
				left = right;
			}
			right++;
		}
		if (right == formula.length()) {
			res.put(formula.substring(left, right), res.getOrDefault(formula.substring(left, right), 0) + 1);
		}

		return res;
	}

	public static void main(String[] args) {
		CountOfAtoms726 c = new CountOfAtoms726();
		// Map<String,Integer> res = c.getAtomsCount("ON");
		String res = c.countOfAtoms("N");
		System.out.println(res.toString());
	}

}