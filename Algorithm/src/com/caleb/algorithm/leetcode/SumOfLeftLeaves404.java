package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-01 23:14:43
 * 
 *       左叶子之和
 * 
 *       计算给定二叉树的所有左叶子之和。
 * 
 */
public class SumOfLeftLeaves404 {

	int countRes = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		dfs(root, 0);
		return countRes;
	}

	public void dfs(TreeNode root, int left) {
		if (root.left == null && root.right == null) {
			if (left == 1) {
				countRes += root.val;
			}
		}
		if (root.left != null) {
			dfs(root.left, 1);
		}
		if (root.right != null) {
			dfs(root.right, 0);
		}
	}

}