package com.caleb.alorithm.leetcode;

import com.caleb.offerdemo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * @author：hanzhigang
 * @Date : 2021/4/16 7:10 PM
 */
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    /**
     * 递归形式
     *
     * @param p
     * @param q
     * @return
     */
    private boolean isSymmetricHelper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left);
    }

    public boolean isSymmetricHelper1(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null){
                continue;
            }
            if(t1 == null || t2 == null || (t1.val != t2.val)){
                return false;
            }
            queue.offer(t1.left);
            queue.offer(t2.right);

            queue.offer(t1.right);
            queue.offer(t2.left);



        }
        return true;
    }
}
