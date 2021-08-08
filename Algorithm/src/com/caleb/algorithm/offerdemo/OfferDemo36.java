package com.caleb.algorithm.offerdemo;

import java.util.Stack;

/**
 * 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * @author：hanzhigang
 * @Date : 2021/3/11 9:10 AM
 */
public class OfferDemo36 {

    TreeNode pre, head;

    /**
     * 三个问题，最小的节点指向最大的节点，最大的节点指向最小的节点，3 -> 4
     * 尝试使用单调栈
     *
     * @param root
     * @return
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode head = new TreeNode(-1);
        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curNode.left != null) {
            stack.add(curNode);
            curNode = curNode.left;
        }
        stack.add(curNode);
        head.right = curNode;
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            if (curNode.right == null) {
                if (!stack.isEmpty()) {
                    curNode.right = stack.peek();
                    stack.peek().left = curNode;
                }
            } else {
                stack.add(curNode.right);
                System.out.println(stack.peek().val);
                while (stack.peek().left != null) {
                    stack.add(stack.peek().left);
                }
                curNode.right = stack.peek();
                stack.peek().left = curNode;
            }

        }
        head.right.left = curNode;
        curNode.right = head.right;
        return head.right;
    }

//  利用中序遍历，遍历完的二叉搜索树是有序的
    public TreeNode treeToDoublyList1(TreeNode root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(TreeNode cur) {

        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        OfferDemo36 offerDemo36 = new OfferDemo36();
        System.out.println(offerDemo36.treeToDoublyList(node4).left.left.left.left.left.val);
    }
}
