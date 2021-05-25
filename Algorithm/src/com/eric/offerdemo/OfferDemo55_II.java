package com.eric.offerdemo;

/**
 * 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @author：hanzhigang
 * @Date : 2021/3/15 10:11 PM
 */
public class OfferDemo55_II {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {

        dfs(root);
        return flag;

    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int curLeftDepth = dfs(root.left);
        int curRightDepth = dfs(root.right);
//      如果左右子树高度差超过1，将flag置为false
        if(Math.abs(curLeftDepth-curRightDepth)>1){
            flag = false;
        }
        return Math.max(curLeftDepth,curRightDepth)+1;
    }
}
