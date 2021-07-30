package com.caleb.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-07-30 14:30:56
 * 
 *       二叉树的前序遍历
 * 
 */
public class PreorderTraversal144 {

	List<Integer> res;

	public List<Integer> preorderTraversal(TreeNode root) {
		res = new ArrayList<>();
		preorderTraversalHelper(root);
		return res;
	}

	public void preorderTraversalHelper(TreeNode root) {
		if (root != null) {
			res.add(root.val);
			preorderTraversalHelper(root.left);
			preorderTraversalHelper(root.right);
		}
	}

	/**
	 * 迭代法
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal1(TreeNode root) {
		res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				res.add(curr.val);
				stack.add(curr);
				curr = curr.left;
			} else {
				curr = stack.pop().right;
			}
		}
		return res;
	}

}