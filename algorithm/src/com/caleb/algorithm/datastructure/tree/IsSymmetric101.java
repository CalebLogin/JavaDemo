package com.caleb.algorithm.datastructure.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-01 20:15:02
 */
public class IsSymmetric101 {

	boolean isS = true;

	public boolean isSymmetric(TreeNode root) {
		dfs(root, root);
		return isS;
	}

	private void dfs(TreeNode root1, TreeNode root2) {
		if(root1 != null || root2 != null){
			if ((root1 == null && root2 != null) || (root1 != null && root2 == null) || (root1.val != root2.val)) {
				isS = false;
				return;
			}
			dfs(root1.left, root2.right);
			dfs(root1.right, root2.left);
		}
		
		
	}

}