package com.eric.alorithm.leetcode;

import com.eric.offerdemo.TreeNode;

import java.util.LinkedList;

/**
 * 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * @author：hanzhigang
 * @Date : 2021/4/27 9:54 PM
 */
public class RangeSumBST938 {

    /**
     * 利用中序遍历有序的特点
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {

        int count = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root.left != null) {
            stack.offerLast(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode l = stack.pollLast();
            if (l.val == low || l.val == high || count != 0) {
                count += l.val;
                if (l.val == high) {
                    break;
                }
            }

            l = l.right;
            while (l != null) {
                stack.add(l);
                l = l.left;
            }
        }
        return count;
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST1(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST1(root.right, low, high);
        }
        return root.val + rangeSumBST1(root.left, low, high) + rangeSumBST1(root.right, low, high);
    }


}
