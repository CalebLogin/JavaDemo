package com.caleb.algorithm.datastructure.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-01 21:46:18
 */
public class CountNodes222 {

	int finalCount = 0;

	public int countNodes(TreeNode root) {
		if (root != null) {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
		return 0;
	}

}