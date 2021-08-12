package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-01 20:25:40
 * 
 *       二叉树的最小深度
 * 
 *       给定一个二叉树，找出其最小深度。
 * 
 *       最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 *       说明：叶子节点是指没有子节点的节点。
 * 
 * 
 */
public class MinDepth111 {

	int minD = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {
		dfs(root, 1);
		return minD;
	}

	private void dfs(TreeNode root, int d) {
		if (root.left == null && root.right == null) {
			minD = Math.min(minD, d);
			return;
		}
		if (root.left != null) {
			dfs(root.left, d + 1);
		}
		if (root.right != null) {
			dfs(root.right, d + 1);
		}

	}

}