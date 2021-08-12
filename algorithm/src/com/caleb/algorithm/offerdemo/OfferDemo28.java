package com.caleb.algorithm.offerdemo;

/**
 * 对称的二叉树
 *
 * @author：hanzhigang
 * @Date : 2021/3/6 7:20 PM
 */
public class OfferDemo28 {

    //  利用递归完成判断,层次遍历完成判断
    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return helper(root.left, root.right);
        }
        return true;
    }

    public boolean helper(TreeNode root1, TreeNode root2) {
//      遍历过叶子节点，返回true
        if (root1 == null && root2 == null) {
            return true;
        }
//      有一个叶子节点为空，另一个不为空，返回false
        if (root1 == null || root2 == null) {
            return false;
        }
//      节点值相同，且节点1的左子树等于节点2的右子树，节点1的右子树等于节点2的左子树，返回true
        return (root1.val == root2.val) && helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        OfferDemo28 offerDemo28 = new OfferDemo28();
        System.out.println(offerDemo28.isSymmetric(treeNode1));
    }
}
