package com.caleb.algorithm.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-01 23:38:47
 * 
 *       从中序和后序遍历序列构造二叉树
 * 
 *       根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 */
public class BuildTree106 {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode buildTreeHelper(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
		if (il < ir) {
			TreeNode root = new TreeNode(postorder[pr]);
			int i = il;
			for (; i <= ir; i++) {
				if (root.val == inorder[i]) {
					break;
				}
			}

			root.left = buildTreeHelper(inorder, il, i - 1, postorder, pl, pl + (i - il -1));
			root.right = buildTreeHelper(inorder, i + 1, ir, postorder, pl + (i - il), pr - 1);
			return root;
		} else if (il == ir) {
			return new TreeNode(inorder[il]);
		}
		return null;
	}

}