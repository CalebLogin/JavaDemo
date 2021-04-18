package com.eric.alorithm.leetcode;

import com.eric.offerdemo.TreeNode;

/**
 * 二叉树的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * @author：hanzhigang
 * @Date : 2021/4/18 8:20 PM
 */
public class MaxPathSum124 {
    int maxV = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxV;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 返回左子树的数值，如果小于0，则等于0
        int left = Math.max(maxPathSumHelper(root.left), 0);
        // 返回左子树的数值，如果小于0，则等于0
        int right = Math.max(maxPathSumHelper(root.right), 0);
        int tmp = left + right + root.val;
        // 比较当前结果与最大值，判断是否更新最大值
        maxV = Math.max(tmp, maxV);
        // 返回上一层，继续比较
        return root.val + Math.max(left,right);
    }
}
