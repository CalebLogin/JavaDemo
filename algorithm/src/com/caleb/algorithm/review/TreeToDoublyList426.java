package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-09-02 20:18:09
 */
public class TreeToDoublyList426 {

	private Node preNode = new Node(-1005);
	private Node pre = preNode;
	private Node after = null;

	public Node treeToDoublyList(Node root) {
		dfs(root);
		if(pre.right != null){
			pre.right.left = after;
			after.right = pre.right;
		}
		return pre.right;
	}

	public void dfs(Node node) {
		if (node == null) {
			return;
		}
		dfs(node.left);
		preNode.right = node;
		preNode = node;
		if(after != null){
			node.left = after;
		}
		after = node;
		dfs(node.right);

	}

}

class Node {
	public int val;
	public Node left;
	public Node right;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
}