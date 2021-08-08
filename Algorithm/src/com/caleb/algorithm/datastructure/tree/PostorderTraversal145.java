package com.caleb.algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-07-30 14:32:59
 * 
 *       二叉树的后序遍历
 * 
 */
public class PostorderTraversal145 {

	List<Integer> res;

	public List<Integer> postorderTraversal(TreeNode root) {
		res = new ArrayList<>();
		postorderTraversalHelper(root);
		return res;
	}

	private void postorderTraversalHelper(TreeNode root) {
		if (root != null) {
			postorderTraversalHelper(root.left);
			postorderTraversalHelper(root.right);
			res.add(root.val);
		}
	}

	/**
	 * 迭代法
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal1(TreeNode root) {
		res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		Set<TreeNode> visited = new HashSet<>();
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				visited.add(curr);
				stack.add(curr);
				curr = curr.left;
			} else {
				curr = stack.peek();
				if (curr.right != null && !visited.contains(curr.right)) {
					curr = curr.right;
				} else {
					curr = stack.pop();
					res.add(curr.val);
					curr = null;
				}
			}
		}
		return res;
	}

}