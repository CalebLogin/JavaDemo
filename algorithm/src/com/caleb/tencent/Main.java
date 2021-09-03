package com.caleb.tencent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-09-02 14:49:20
 * 
 *       二叉树蛇形打印
 * 
 */
public class Main {

	public static List<Integer> printTreeNode(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> q = new ArrayDeque<>();
		if (root == null) {
			return res;
		}
		q.offer(root);
		int i = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				// 第偶数层
				if ((i & 1) == 0) {
					TreeNode node = q.pollFirst();
					res.add(node.val);
					if (node.left != null) {
						q.offerLast(node.left);
					}
					if (node.right != null) {
						q.offerLast(node.right);
					}
				} else {
					TreeNode node = q.pollLast();
					res.add(node.val);
					if (node.right != null) {
						q.offerFirst(node.right);
					}
					if (node.left != null) {
						q.offerFirst(node.left);
					}
				}
			}
			i++;
		}
		return res;
	}


	public static void main(String[] args) {
		TreeNode node1 =new TreeNode(1);
		TreeNode node2 =new TreeNode(2);
		TreeNode node3 =new TreeNode(3);
		TreeNode node4 =new TreeNode(4);
		TreeNode node5 =new TreeNode(5);
		TreeNode node6 =new TreeNode(6);
		TreeNode node7 =new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node6;
		node6.left = node5;
		node6.right = node7;
		System.out.println(printTreeNode(node1).toString());
	}	

}