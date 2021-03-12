package com.eric.offerdemo;

import java.util.Stack;

/**
 * 输出二叉树的镜像
 *
 * @author：hanzhigang
 * @Date : 2021/3/6 6:54 PM
 */
public class OfferDemo27 {

    //  利用递归完成镜像的反转
    public TreeNode mirrorTree(TreeNode root) {
//      如果当前节点不为空，找到左节点和右节点，反转
        if (root != null) {
            TreeNode left = mirrorTree(root.left);
            TreeNode right = mirrorTree(root.right);
            root.left = right;
            root.right = left;
        }
        return root;
    }

    //  不利用递归完成反转，利用栈来实现，左边右，右变左
    public TreeNode mirrorTree1(TreeNode root) {
        if (root != null) {
            //      新建栈，用来存放后续的左节点和右节点
            Stack<TreeNode> stack = new Stack<>();
//      新建树节点，将新建树节点等于根结点，并压入栈
            TreeNode curNode = root;
            stack.push(curNode);
//      当栈不为空，持续遍历
            while (!stack.isEmpty()) {
//          弹出栈顶节点
                curNode = stack.pop();
//          栈顶节点的左子树和右子树不为空，将左子树和右子树的根结点压入栈
                if (curNode.left != null) {
                    stack.push(curNode.left);
                }
                if (curNode.right != null) {
                    stack.push(curNode.right);
                }
//          左节点和右节点互换位置
                TreeNode node = curNode.left;
                curNode.left = curNode.right;
                curNode.right = node;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        OfferDemo27 offerDemo27 = new OfferDemo27();
        System.out.println(offerDemo27.mirrorTree1(treeNode1).right.val);
    }
}
