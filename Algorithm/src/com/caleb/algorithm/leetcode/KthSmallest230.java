package com.caleb.algorithm.leetcode;

import com.caleb.offerdemo.TreeNode;

/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）
 *
 * @author: hanzhigang
 * @Date : 2021/5/18 19:31
 */
public class KthSmallest230 {
    int count = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if(root != null){
            dfs(root.left, k);
            if (++count == k) {
                res = root.val;
                return;
            }
            dfs(root.right, k);
        }
    }
}
