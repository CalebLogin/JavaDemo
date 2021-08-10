package com.caleb.algorithm.datastructure.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-10 14:38:55
 * 
 * 二叉搜索树的插入
 *
 */
public class InsertIntoBST701 {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (root.val < val) {
			root.right = insertIntoBST(root.right, val);
		}else{
			root.left = insertIntoBST(root.left, val);
		}
		return root;
	}

}