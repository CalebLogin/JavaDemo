package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-07-29 12:17:28
 */
public class DistanceK863 {

	Map<Integer, TreeNode> parent = new HashMap<>();
	Set<Integer> visited = new HashSet<>();
	List<Integer> res = new ArrayList<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		dfs(root);
		visited.add(target.val);
		helper(target, k);
		return res;
	}

	public void helper(TreeNode target, int k) {
		if (k == 0) {
			res.add(target.val);
		}
		if (k > 0) {
			if (parent.containsKey(target.val) &&!visited.contains(parent.get(target.val).val)) {
				visited.add(parent.get(target.val).val);
				helper(parent.get(target.val), k - 1);
			}
			if (target.left != null && !visited.contains(target.left.val)) {
				visited.add(target.left.val);
				helper(target.left, k - 1);
			}
			if (target.right != null && !visited.contains(target.right.val)) {
				visited.add(target.right.val);
				helper(target.right, k-1);
			}
		}
	}

	public void dfs(TreeNode root) {
		if (root.left != null) {
			dfs(root.left);
			parent.put(root.left.val, root);
		}
		if (root.right != null) {
			dfs(root.right);
			parent.put(root.right.val, root);
		}
	}

}