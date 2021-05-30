package com.caleb.algorithm.leetcode;

import com.caleb.offerdemo.TreeNode;

import java.util.*;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * @author：hanzhigang
 * @Date : 2021/4/16 3:46 PM
 */
public class InorderTraversal94 {

    /**
     * 栈实现
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> d = new ArrayDeque<>(); // 定义栈存放节点
        List<Integer> res = new ArrayList<>();  // 存放返回结果
        TreeNode node;
        while(root != null){
            d.offerLast(root);
            root = root.left;
        }
        while (!d.isEmpty()) {
            node = d.removeLast();
            res.add(node.val);  // 左子节点为空时，将当前根结点加入List中
            if (node.right != null) { // 右子节点不为空，添加
                node = node.right;
                while(node != null){
                    d.offerLast(node);
                    node = node.left;
                }
            }
        }
        return res;
    }

    /**
     * 递归实现
     */
    ArrayList<Integer> res1 = new ArrayList<>();
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        inorderHelper(root);
        return res1;
    }

    private void inorderHelper(TreeNode root){
        if(root.left != null){
            inorderHelper(root.left);
        }
        res1.add(root.val);
        if(root.right != null){
            inorderHelper(root.right);
        }
    }



    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        InorderTraversal94 inorderTraversal94 = new InorderTraversal94();
        List<Integer> res = inorderTraversal94.inorderTraversal(treeNode1);
        for (Integer i : res) {
            System.out.print(i + "-");
        }
    }
}
