package com.caleb.demo;

/**
 * @author：hanzhigang
 * @Date : 2020/11/29 11:40 PM
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){};
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(TreeNode left,TreeNode right){
        this.left = left;
        this.right = right;
    }
    
    
}
