package com.caleb.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-01 22:05:52
 * 
 *       二叉树的所有路径
 * 
 *       给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 *       说明: 叶子节点是指没有子节点的节点。
 * 
 * 
 */
public class BinaryTreePaths257 {

	List<Integer> list;
	List<String> res;

	public List<String> binaryTreePaths(TreeNode root) {
		list = new ArrayList<>();
		res = new ArrayList<>();
		dfs(root);
		return res;
	}

	public void dfs(TreeNode root) {

		list.add(root.val);
		if (root.left == null && root.right == null) {
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				stringBuffer.append(String.valueOf(list.get(i)));
				if (i != list.size() - 1) {
					stringBuffer.append("->");
				}
			}
			res.add(stringBuffer.toString());
			list.remove(list.size() - 1);
			return;
		}
		if (root.left != null) {
			dfs(root.left);
		}
		if (root.right != null) {
			dfs(root.right);
		}

		list.remove(list.size() - 1);
	}

}