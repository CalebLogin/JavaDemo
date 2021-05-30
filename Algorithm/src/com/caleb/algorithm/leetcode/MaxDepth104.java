package com.caleb.algorithm.leetcode;

import com.caleb.offerdemo.TreeNode;

/**
 * 二叉树最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author：hanzhigang
 * @Date : 2021/4/16 10:01 PM
 */
public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
