package com.caleb.algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-08 21:50:08
 * 
 *       二叉搜索树中的众数
 * 
 *       给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 *       假定 BST 有如下定义：
 * 
 *       结点左子树中所含结点的值小于等于当前结点的值 结点右子树中所含结点的值大于等于当前结点的值 左子树和右子树都是二叉搜索树 例如： 给定 BST
 *       [1,null,2,2]
 */
public class FindMode501 {

	List<Integer> res = new ArrayList<>();
	int maxCount = 0;
	int preCount = 0;
	TreeNode preNode = null;

	public int[] findMode(TreeNode root) {
		dfs(root);
		int[] array = res.stream().mapToInt(i -> i.intValue()).toArray();
		return array;
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		if (preNode != null) {
			if (root.val == preNode.val) {
				preCount++;
			} else {
				preCount = 1;
			}
		}else{	
			preCount++;
		}
		preNode = root;
		if (preCount > maxCount) {
			res.clear();
			maxCount = preCount;
			res.add(root.val);
		} else if (preCount == maxCount) {
			res.add(root.val);
		}
		

		dfs(root.right);
	}

}