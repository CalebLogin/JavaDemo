package com.caleb.algorithm.datastructure.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-08 21:37:04
 * 
 *       验证二叉搜索树
 * 
 *       给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 *       假设一个二叉搜索树具有如下特征：
 * 
 *       节点的左子树只包含小于当前节点的数。 节点的右子树只包含大于当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树
 */
public class IsValidBST98 {

	TreeNode pre = null;
	boolean flag = true;

	public boolean isValidBST(TreeNode root) {
		dfs(root);
		return flag;
	}

	private void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		if (pre == null) {
			pre = root;
		} else {
			if (pre.val >= root.val) {
				flag = false;
				return;
			}
			pre = root;
		}
		dfs(root.right);
	}

}