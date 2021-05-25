package com.eric.alorithm.leetcode;

import com.eric.offerdemo.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 11:47 PM
 */
public class BuildTree105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder,int[] inorder,int preStart,int preEnd,int inStart,int inEnd){
        if(preStart > preEnd){
            return null;
        }
        if(preStart == preEnd){
            // 如果当前节点是叶子节点，直接返回该节点
            return new TreeNode(preorder[preStart]);
        }
        // 新建某子树的根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        int i;
        // 找到中序遍历中的子树根节点，该点左边为左子树，该点右边为右子树
        for(i = inStart;i<inEnd;i++){
            if(inorder[i] == preorder[preStart]){
                break;
            }
        }
        root.left = buildTreeHelper(preorder,inorder,preStart+1,preStart+i-inStart,inStart,i-1);
        root.right = buildTreeHelper(preorder,inorder,preStart+i-inStart+1,preEnd,i+1,inEnd);
        return root;
    }

    private TreeNode buildTreeHelper1(int[] preorder, int[] inorder, int prel, int prer, int inl, int inr) {
        if (inl > inr) {
            return null;
        }
        TreeNode node;
        int i;
        for (i = 0; i < inr - inl && inorder[i + inl] != preorder[prel]; i++) ;
        node = new TreeNode(inorder[inl + i]);
        node.left = buildTreeHelper1(preorder, inorder, prel + 1, prel + i - 1, inl, inl + i - 1);
        node.right = buildTreeHelper1(preorder, inorder, prel + i + 1, prer, inl + i + 1, inr);
        return node;
    }

}
