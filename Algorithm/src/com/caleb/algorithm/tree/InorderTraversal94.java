package com.caleb.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.caleb.demo.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-07-30 14:24:21
 * 
 *       二叉树中序遍历
 * 
 */
public class InorderTraversal94 {

	List<Integer> res;

	public List<Integer> inorderTraversal(TreeNode root) {
		res = new ArrayList<>();
		inorderTraversalHelper(root);
		return res;
	}

	public void inorderTraversalHelper(TreeNode root) {
		if (root != null) {
			inorderTraversalHelper(root.left);
			res.add(root.val);
			inorderTraversalHelper(root.right);
		}
	}

	/**
	 * 迭代的方式
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal1(TreeNode root) {
		res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) {
			return res;
		}
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.add(cur);
				cur = cur.left;
			}else{
				cur = stack.pop();
				res.add(cur.val);
				cur = cur.right;	
			}
			
		}
		return res;
	}

}