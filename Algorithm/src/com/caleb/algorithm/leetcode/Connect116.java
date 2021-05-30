package com.caleb.algorithm.leetcode;

/**
 * 填充每一个节点的下一个右侧节点指针
 * 给定一个 **完美二叉树** ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * @author：hanzhigang
 * @Date : 2021/4/17 8:42 PM
 */
public class Connect116 {
    /**
     * 利用递归的解法
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connectHelper(root.left, root.right);
        return root;
    }

    private void connectHelper(Node l, Node r) {
        if (l == null) {    // 因为是完美二叉树，l为空，则一层内都没有节点
            return;
        }
        l.next = r;
        connectHelper(l.left, l.right); // 连接同一个节点内的左右子节点
        connectHelper(l.right, r.left); // 连接相邻节点之间的右节点和左节点
        connectHelper(r.left, r.right); // 连接相邻节点的左节点和右节点
    }

    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }

        Node leftmost = root;   // 记录每一层的最左节点
        while (leftmost != null) { // 当前节点不为空时
            Node head = leftmost;
            while (head != null && head.left != null) {  // 利用head.next的性质，一直向右遍历，建立next关系
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    /**
     * 纵深版的递归
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        /*Node l = root.left;
        Node r = root.right;
        while(l != null){   // 建立两个节点之间的next关系，将整个纵深串联起来
            l.next = r;
            l = l.right;
            r = r.left;
        }
        connect2(root.left);
        connect2(root.right);*/
        dfs(root);
        return root;
    }

    void dfs(Node root) {
        if (root == null) return;
        Node l = root.left;
        Node r = root.right;
        while (l != null) {
            l.next = r;
            l = l.right;
            r = r.left;
        }
        dfs(root.left);
        dfs(root.right);
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
