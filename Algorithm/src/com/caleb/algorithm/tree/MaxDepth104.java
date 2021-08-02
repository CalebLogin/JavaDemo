package com.caleb.algorithm.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-01 20:23:02
 */
public class MaxDepth104 {

	int maxD = 0;

	public int maxDepth(TreeNode root) {
		dfs(root, 1);
		return maxD;
	}

	private void dfs(TreeNode root, int d) {
		if (root != null) {
			maxD = Math.max(maxD, d);
			dfs(root.left, d + 1);
			dfs(root.right, d + 1);
		}
	}

}