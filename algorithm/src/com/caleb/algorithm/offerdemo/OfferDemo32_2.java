package com.caleb.algorithm.offerdemo;

import java.util.*;

/**
 * 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * @author：hanzhigang
 * @Date : 2021/3/8 9:46 PM
 */
public class OfferDemo32_2 {

    List<List<Integer>> res = new ArrayList<>();
    Map<TreeNode, Integer> map;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
//      root节点，深度为0
        addTreeNode(root, 0);
        return res;
    }

    public void addTreeNode(TreeNode node, int depth) {
//      如果深度等于list大小，说明还没有创建对应深度的list，创建list
        if (depth == res.size()) {
            List<Integer> subList = new ArrayList<>();
            subList.add(node.val);
            res.add(subList);
        } else {
            res.get(depth).add(node.val);
        }
//      若节点不为空，继续添加加1深度的树节点
        if (node.left != null) {
            addTreeNode(node.left, depth + 1);
        }
        if (node.right != null) {
            addTreeNode(node.right, depth + 1);
        }
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
            res.add(temp);
        }
//      返回结果
        return res;
    }
}
