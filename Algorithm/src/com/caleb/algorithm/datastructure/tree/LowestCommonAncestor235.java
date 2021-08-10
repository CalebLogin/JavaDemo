package com.caleb.algorithm.datastructure.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-09 23:37:42
 * 
 *       二叉树搜索树的最近公共祖先
 */
public class LowestCommonAncestor235 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
		if (leftNode == null) {
			return rightNode;
		}
		if (rightNode == null) {
			return leftNode;
		}
		return root;
	}

	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode ancestor = root;
		while (true) {
			if (p.val > ancestor.val && q.val > ancestor.val) {
				ancestor = ancestor.right;
			} else if (p.val < ancestor.val && q.val < ancestor.val) {
				ancestor = ancestor.left;
			} else {
				break;
			}
		}
		return ancestor;
	}

}