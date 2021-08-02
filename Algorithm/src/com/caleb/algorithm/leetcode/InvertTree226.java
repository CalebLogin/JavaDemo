package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-01 20:08:05
 * 
 *       反转二叉树
 * 
 *       翻转一棵二叉树。
 */
public class InvertTree226 {

	/**
	 * 中序遍历
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		dfs(root);
		return root;
	}

	private void dfs(TreeNode node) {
		if (node != null) {
			dfs(node.left);
			dfs(node.right);
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

}