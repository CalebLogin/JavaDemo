package com.caleb.offerdemo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * @author：hanzhigang
 * @Date : 2021/3/8 8:40 PM
 */
public class OfferDemo32_1 {
    /**
     * 利用队列来完成节点的打印
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
//      如果树根结点为空，返回空
        if (root == null) {
            return new int[]{};
        }
//      定义队列来保存节点
        Deque<TreeNode> deque = new LinkedList<>();
//      定义List来作为返回结果
        List<Integer> list = new ArrayList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            list.add(node.val);
            if (node.left != null) {
                deque.offer(node.left);
            }
            if(node.right != null){
                deque.offer(node.right);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
