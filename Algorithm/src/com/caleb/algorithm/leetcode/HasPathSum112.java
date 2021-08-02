package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-01 23:32:05
 * 
 *       路径总和
 * 
 *       给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点
 *       的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 
 *       叶子节点 是指没有子节点的节点。
 */
public class HasPathSum112 {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root != null) {
			// 当前节点是叶子节点
			if (root.left == null && root.right == null) {
				return targetSum == root.val;
			} else if (targetSum > 0) {
				return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
			}
		}
		return false;
	}

}