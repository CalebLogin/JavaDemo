package com.caleb.algorithm.offerdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * @author：hanzhigang
 * @Date : 2021/3/22 10:46 PM
 */
public class OfferDemo68_II {
    List<TreeNode> listp = new ArrayList<>();
    List<TreeNode> listq = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 存放节点的列表，存储根结点到p、q节点的所有父节点

        TreeNode curNode = root;
        listp.add(curNode);
        listq.add(curNode);
        dfs(curNode, p, listp);
        dfs(curNode, q, listq);
        int len = Math.min(listp.size(), listq.size());
        while (len > 0) {
            if (listp.get(len - 1) == listq.get(len - 1)) {
                return listp.get(len - 1);
            } else {
                --len;
            }
        }
        return root;

    }

    public void dfs(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root.val == target.val) {
            return;
        }
        if (root.left != null) {
//            System.out.println(root.left.val);
            list.add(root.left);
            dfs(root.left, target, list);
            if(list.get(list.size()-1) == target){
                return;
            }else{
                list.remove(list.size()-1);
            }
        }
        if (root.right != null) {
            list.add(root.right);
            dfs(root.right, target, list);
            if(list.get(list.size()-1) == target){
                return;
            }else{
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        OfferDemo68_II offerDemo68_ii = new OfferDemo68_II();
        System.out.println(offerDemo68_ii.lowestCommonAncestor(node1, node2, node3).val);
    }

}
