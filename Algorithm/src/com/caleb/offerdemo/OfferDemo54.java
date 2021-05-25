package com.caleb.offerdemo;

import java.util.Stack;

/**
 * 二叉搜索数第K大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * @author：hanzhigang
 * @Date : 2021/3/15 9:43 PM
 */
public class OfferDemo54 {

    int k,res;

    /**
     * 利用先序遍历有序的想法
     * 利用栈的思想
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
//      首先将最右子树放入栈中
        while(root != null){
            stack.push(root);
            root = root.right;
        }
        // 在栈不为空的情况下，取出一个节点，并将k--，如果k==0，返回值
        while(!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            if(--k == 0){
                return curNode.val;
            }
//          如果当前节点左子树不为空，加入左子树节点，并将该节点的右子树加入栈中
            if(curNode.left!=null){
                stack.push(curNode.left);
                TreeNode append = curNode.left;
                while(append.right != null){
                    stack.push(append.right);
                    append = append.right;
                }
            }
        }
        return 0;
    }

    public int kthLargest1(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(k==0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
