package com.caleb.algorithm.datastructure.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-08 21:44:15
 * 
 *       二叉搜索树的最小绝对差
 * 
 *       给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 
 */
public class GetMinimumDifference530 {

	/**
	 * 利用中序遍历有序寻找最小绝对差
	 * 
	 * @param root
	 * @return
	 */
	TreeNode pre = null;
	int minDivision = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		dfs(root);
		return minDivision;
	}

	public void dfs(TreeNode root) {
		if (root != null) {
			dfs(root.left);
			if (pre != null) {
				minDivision = Math.min(Math.abs(pre.val - root.val), minDivision);
			}
			pre = root;
			dfs(root.right);
		}

	}

}