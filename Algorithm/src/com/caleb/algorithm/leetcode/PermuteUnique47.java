package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 全排列II 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * @author:Caleb
 * @Date :2021-06-22 15:19:27
 */
public class PermuteUnique47 {

	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		permuteHelper(nums, 0);
		return res;
	}

	private void permuteHelper(int[] nums, int x) {
		if (x == nums.length - 1) {
			List<Integer> resl = new ArrayList<>();
			for (Integer i : nums) {
				resl.add(i);
			}
			res.add(resl);
			return;
		}

		// 如果当前遍历过程中，i, j 位置数字相同，那么nums[x] 与i,j发生两次相同的交换
		// 为了防止出现重复数据，用set进行去重
		Set<Integer> set = new HashSet<>();
		for (int i = x; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				continue;
			}
			set.add(nums[i]);
			swap(nums, x, i);
			permuteHelper(nums, x+1);
			swap(nums, x, i);
		}
	}

	private void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

}