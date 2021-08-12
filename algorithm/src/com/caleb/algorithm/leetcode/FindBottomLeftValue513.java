package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-01 23:21:43
 * 
 *       找树左下角的值
 * 
 *       给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 
 *       假设二叉树中至少有一个节点。
 * 
 * 
 * 
 */
public class FindBottomLeftValue513 {

	int leftV = 0, leftP = 0;

	public int findBottomLeftValue(TreeNode root) {
		dfs(root, 1);
		return leftV;
	}

	private void dfs(TreeNode root, int level) {
		if (root.left == null && root.right == null) {
			if (level > leftP) {
				leftP = level;
				leftV = root.val;
			}
		}
		if (root.left != null) {
			dfs(root.left, level + 1);
		}
		if (root.right != null) {
			dfs(root.right, level + 1);
		}
	}

}