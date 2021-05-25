package com.caleb.offerdemo;

import java.util.*;

/**
 * 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * @author：hanzhigang
 * @Date : 2021/3/8 10:16 PM
 */
public class OfferDemo32_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
//      如果根结点为空，则返回空
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
//      记录行号
        int depth = 1;
//      定义队列，存放树节点
        Deque<TreeNode> deque = new LinkedList<>();
//      定义返回结果list
        List<List<Integer>> res = new ArrayList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
//          定义list，存放当前深度的节点
            List<Integer> temp = new ArrayList<>();
//          在deque.size-1 ~ 0存放的是同一深度的树节点，循环加入list
            for (int i = deque.size() - 1; i >= 0; i--) {
                TreeNode node = deque.poll();
                temp.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            if((depth & 1) == 1){
                Collections.reverse(temp);
            }
            depth++;
            res.add(temp);
        }
//      返回结果
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
//      如果根结点为空，则返回空
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
//      定义队列，存放树节点
        Deque<TreeNode> deque = new LinkedList<>();
//      定义返回结果list
        List<List<Integer>> res = new ArrayList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
//          定义list，存放当前深度的节点
            LinkedList<Integer> temp = new LinkedList<>();
//          在deque.size-1 ~ 0存放的是同一深度的树节点，循环加入list
            for (int i = deque.size() - 1; i >= 0; i--) {
                TreeNode node = deque.poll();
                if(res.size() % 2 == 0) temp.addLast(node.val); // 偶数层 -> 队列头部
                else temp.addFirst(node.val); // 奇数层 -> 队列尾部
                temp.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res.add(temp);
        }
//      返回结果
        return res;
    }
}
