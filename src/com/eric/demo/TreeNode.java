package demo;

import apple.laf.JRSUIUtils;

/**
 * @author：hanzhigang
 * @Date : 2020/11/29 11:40 PM
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){};
    public TreeNode(TreeNode left,TreeNode right){
        this.left = left;
        this.right = right;
    }
}
