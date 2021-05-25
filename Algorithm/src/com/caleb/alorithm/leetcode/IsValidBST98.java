package com.eric.alorithm.leetcode;

import com.eric.offerdemo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 利用中序遍历成升序的性质
 *
 * @author：hanzhigang
 * @Date : 2021/4/16 5:15 PM
 */
public class IsValidBST98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> d = new ArrayDeque<>();
        int prev;
        TreeNode node;
        while (root.left != null) {
            d.offerLast(root);
            root = root.left;
        }
        prev = root.val;
        d.offerLast(root);
        while (!d.isEmpty()) {
            node = d.pollLast();
            if (node != root) {
                if (node.val <= prev) {
                    return false;
                }
            }
            prev = node.val;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    d.offerLast(node);
                    node = node.left;
                }
            }
        }
        return true;
    }

    int prev;

    public boolean isValidBST1(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long l1, long l2) {
        if (root == null) return true;
        if (l1 >= root.val || l2 <= root.val) {
            return false;
        }
        return isValidBSTHelper(root.left, l1, root.val) && isValidBSTHelper(root.right, root.val, l2);
    }


}
