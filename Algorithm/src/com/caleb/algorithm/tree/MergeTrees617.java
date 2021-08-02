package com.caleb.algorithm.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-02 00:13:00
 */
public class MergeTrees617 {

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 != null || root2 != null) {
			if (root1 != null && root2 != null) {
				root1.val += root2.val;
				root1.left = mergeTrees(root1.left, root2.left);
				root1.right = mergeTrees(root1.right, root2.right);
				return root1;
			} else if (root2 != null) {
				return root2;
			} else {
				return root1;
			}
		}
		return null;
	}

}