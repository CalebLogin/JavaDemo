package com.eric.alorithm.leetcode;

import com.eric.offerdemo.TreeNode;

/**
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
 * @author：hanzhigang
 * @Date : 2021/3/25 11:29 PM
 */
public class LowestCommonAncestor236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q) return root; // 遍历到叶子节点不符合条件或者碰到p、q时马上返回

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;

        // 如果左右都不为空，说明p、q分别位于该节点的两侧，最近公共祖先是当前节点
        return root;
    }
}
