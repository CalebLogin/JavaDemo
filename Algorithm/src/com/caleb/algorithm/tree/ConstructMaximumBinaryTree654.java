package com.caleb.algorithm.tree;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-02 00:04:14
 * 
 *       最大二叉树
 * 
 *       给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 
 *       二叉树的根是数组 nums 中的最大元素。 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。 右子树是通过数组中 最大值右边部分
 *       递归构造出的最大二叉树。 返回有给定数组 nums 构建的 最大二叉树 。
 * 
 */
public class ConstructMaximumBinaryTree654 {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return buildTreeHelper(nums, 0, nums.length - 1);
	}

	private TreeNode buildTreeHelper(int[] nums, int l, int r) {
		if (l <= r) {
			int maxPos = l;
			int maxV = nums[l];
			for (int i = l; i <= r; i++) {
				if (nums[i] > maxV) {
					maxV = nums[i];
					maxPos = i;
				}
			}
			TreeNode root = new TreeNode(maxV);
			root.left = buildTreeHelper(nums, l, maxPos - 1);
			root.right = buildTreeHelper(nums, maxPos + 1, r);
			return root;
		}
		return null;

	}

}