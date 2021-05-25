package com.caleb.offerdemo;

import java.util.LinkedList;

/**
 * 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * @author：hanzhigang
 * @Date : 2021/3/21 10:56 PM
 */
public class OfferDemo68_I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> res = new LinkedList<>();
        TreeNode node = root;
        while(node != p){
            res.add(node);
            if(node.val < p.val){
                node = node.right;
            }else{
                node = node.left;
            }
        }
        res.add(node);
        while(!res.isEmpty()){
            TreeNode temp = res.getLast();
            if(temp == q){
                return temp;
            }
            while(temp != null){
                if(temp.val < q.val){
                    temp = temp.right;
                }else{
                    temp = temp.left;
                }
                if(temp == q){
                    return res.getLast();
                }
            }
            res.removeLast();
        }
        return root;
    }

    /**
     * 如果当前节点小于p和q，在p、q在当前节点的右子树，如果节点大于p或q，那么p、q在当前节点的左子树，否则该节点就是分岔点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while(ancestor != null){
            if(ancestor.val > p.val && ancestor.val > q.val){
                ancestor = ancestor.left;
            }else if(ancestor.val < p.val && ancestor.val < q.val){
                ancestor = ancestor.right;
            }else{
                break;
            }
        }
        return ancestor;
    }
}
