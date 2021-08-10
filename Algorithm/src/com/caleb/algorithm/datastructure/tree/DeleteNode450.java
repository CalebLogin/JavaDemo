package com.caleb.algorithm.datastructure.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-10 11:08:02
 * 
 *       删除二叉搜索树中的节点
 * 
 *       给定一个二叉搜索树的根节点 root 和一个值
 *       key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 
 *       一般来说，删除节点可分为两个步骤：
 * 
 *       首先找到需要删除的节点； 如果找到了，删除它。
 * 
 */
public class DeleteNode450 {

	public TreeNode deleteNode(TreeNode root, int key) {

		if (root == null) {
			return root;
		}
		if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else {
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.right != null) {
				root.val = successor(root);
				root.right = deleteNode(root.right, root.val);
			} else {
				root.val = predecessor(root);
				root.left = deleteNode(root.left, root.val);
			}
		}
		return root;
	}

	public int successor(TreeNode root) {
		root = root.right;
		while (root.left != null) {
			root = root.left;
		}
		return root.val;
	}

	public int predecessor(TreeNode root) {
		root = root.left;
		while (root.right != null) {
			root = root.right;
		}
		return root.val;
	}

}