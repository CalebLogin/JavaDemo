package com.caleb.algorithm.leetcode;

import com.caleb.offerdemo.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树的中继后续
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点。
 *
 * @author：hanzhigang
 * @Date : 2021/6/6 11:37 PM
 */
public class InorderSuccessor285 {
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    /**
     * 递归版
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorder(root, p);
    }

    private TreeNode inorder(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode left = inorder(root.left, p);
        if (p == pre) {
            pre = new TreeNode(Integer.MIN_VALUE);
            return root;
        }
        if (p.val == root.val) {
            pre = p;
        }
        TreeNode right = inorderSuccessor(root.right, p);
        return left == null ? right : left;
    }

    /**
     * 非递归版
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(root != null) {
            s.add(root);
            root = root.left;
        }
        while (!s.isEmpty()) {
            TreeNode tmp = s.pop();
            if(pre == p){
                return tmp;
            }
            if(tmp.val == p.val){
                pre = p;
            }
            tmp = tmp.right;
            while(tmp != null){
                s.add(tmp);
                tmp = tmp.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        InorderSuccessor285 inorderSuccessor285 = new InorderSuccessor285();
        System.out.println(inorderSuccessor285.inorderSuccessor1(node1, node7).val);
    }

}
