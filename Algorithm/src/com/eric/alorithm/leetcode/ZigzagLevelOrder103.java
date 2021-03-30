package com.eric.alorithm.leetcode;

import com.eric.offerdemo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 7:56 PM
 */
public class ZigzagLevelOrder103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 定义结果链表
        List<List<Integer>> res = new ArrayList<>();
        // 定义双端链表
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        // 定义深度
        int d = 0;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (d % 2 != 0) {   // 如果深度为奇数，则从后取，从前进，右子树先进
                    TreeNode node = linkedList.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        linkedList.addFirst(node.right);
                    }
                    if (node.left != null) {
                        linkedList.addFirst(node.left);
                    }
                } else {    // 否则正常取，从前取，左子树先进
                    TreeNode node = linkedList.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        linkedList.addLast(node.left);
                    }
                    if (node.right != null) {
                        linkedList.addLast(node.right);
                    }
                }
            }
            res.add(list);
            d++;
        }
        return res;

    }
}
