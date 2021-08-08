package com.caleb.algorithm.datastructure.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-01 21:54:10
 * 
 *       平衡二叉树
 * 
 *       给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 *       本题中，一棵高度平衡二叉树定义为：
 * 
 *       一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class IsBalanced110 {

	boolean isB = true;

	public boolean isBalanced(TreeNode root) {
		return dfs(root) >= 0;
	}

	public int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftD = dfs(root.left);
		int rightD = dfs(root.right);
		if (leftD == -1 || rightD == -1 || Math.abs(leftD - rightD) > 1) {
			return -1;
		}
		return Math.max(leftD, rightD) + 1;

	}

}