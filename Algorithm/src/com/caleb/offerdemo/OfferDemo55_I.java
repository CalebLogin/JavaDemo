package com.caleb.offerdemo;

/**
 * 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author：hanzhigang
 * @Date : 2021/3/15 10:03 PM
 */
public class OfferDemo55_I {

    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        dfs(root.left, depth + 1);
        if (maxDepth < depth) maxDepth = depth;
        dfs(root.right, depth + 1);
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }
}
