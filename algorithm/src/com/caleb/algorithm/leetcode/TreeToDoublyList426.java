package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-08-04 17:37:00
 * 
 *       将二叉搜索树转换为排序的双向链表 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 * 
 *       对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 
 *       特别地，我们希望可以 就地
 *       完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
 * 
 * 
 */
public class TreeToDoublyList426 {

	/**
	 * 二叉树的中序遍历
	 * 
	 * @param root
	 * @return
	 */
	private Node preNode = new Node(-1005);
	private Node pre = preNode;
	private Node nextNode = null;

	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return root;
		}
		inorder(root);
		pre.right.left = nextNode;
		nextNode.right = pre.right;
		return pre.right;
	}

	private void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			if (preNode.val == -1005) {
				preNode.right = root;
			}
			root.left = preNode;
			preNode = root;
			if (nextNode != null) {
				nextNode.right = root;
			}
			nextNode = root;
			inorder(root.right);
		}
	}
}