package com.caleb.algorithm.leetcode;

import com.caleb.offerdemo.TreeNode;

/**
 * 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值。
 * 思路：回溯
 *
 * @author：hanzhigang
 * @Date : 2021/4/13 8:21 PM
 */
public class MinDiffInBST783 {
    int min = Integer.MAX_VALUE;
    int prev = -1;

    public int minDiffInBST(TreeNode root) {

        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {

        if (root != null) {

            dfs(root.left);
            if(prev == -1){
                prev = root.val;
            }else{
                min = Math.min(root.val-prev,min);
                prev = root.val;
            }

            dfs(root.right);


        }
    }

}
