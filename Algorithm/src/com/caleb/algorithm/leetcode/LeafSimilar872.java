package com.caleb.algorithm.leetcode;

import com.caleb.offerdemo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
 *
 * @author：hanzhigang
 * @Date : 2021/5/10 12:24 AM
 */
public class LeafSimilar872 {

    /**
     * 先序遍历
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, list1);
        }
        if (root2 != null) {
            dfs(root2, list2);
        }
        return list1.equals(list2);
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            if (root.left != null) {
                dfs(root.left, list);
            }
            if (root.right != null) {
                dfs(root.right, list);
            }
        }
    }

}
