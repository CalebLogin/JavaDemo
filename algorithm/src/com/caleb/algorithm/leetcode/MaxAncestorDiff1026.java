package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-08-15 16:53:20
 * 
 *       节点与其祖先之间的最大差值
 * 
 *       给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val -
 *       B.val|，且 A 是 B 的祖先。
 * 
 *       （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * 
 * 
 */
public class MaxAncestorDiff1026 {

	// 建立节点与节点直接的父子关系
	Map<TreeNode, TreeNode> parentNode = new HashMap<>();
	int maxD = Integer.MIN_VALUE;

	public int maxAncestorDiff(TreeNode root) {
		dfs(root);
		for (Map.Entry<TreeNode, TreeNode> entry : parentNode.entrySet()) {
			TreeNode child = entry.getKey();
			int cv = child.val;
			TreeNode parent;
			while ((parent = parentNode.getOrDefault(child, null)) != null) {
				maxD = Math.max(maxD, Math.abs(cv - parent.val));
				child = parent;
			}
		}
		return maxD;
	}

	private void dfs(TreeNode root) {
		if (root != null) {
			dfs(root.left);
			if (root.left != null) {
				parentNode.put(root.left, root);
			}
			if (root.right != null) {
				parentNode.put(root.right, root);
			}
			dfs(root.right);
		}
	}

	public int maxAncestorDiff1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		dfs1(root, root.val, root.val);
		return maxD;
	}

	public void dfs1(TreeNode root, int max, int min) {
		if (root == null) {
			return;
		}
		max = Math.max(max, root.val);
		min = Math.min(min, root.val);
		dfs1(root.left, max, min);
		if (root.left == null && root.right == null) {
			maxD = Math.max(maxD, max - min);
		}
		dfs1(root.right, max, min);
	}

}