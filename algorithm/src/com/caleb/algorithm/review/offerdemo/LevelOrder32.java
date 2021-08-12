package com.caleb.algorithm.review.offerdemo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-04 18:46:56
 */
public class LevelOrder32 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null){
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerFirst(root);
		int level = 0;
		while (!deque.isEmpty()) {
			level++;
			int size = deque.size();
			List<Integer> list = new ArrayList<>();
			if (level % 2 == 1) {
				for (int i = 0; i < size; i++) {
					TreeNode node = deque.pollFirst();
					list.add(node.val);
					if (node.left != null) {
						deque.offerLast(node.left);
					}
					if (node.right != null) {
						deque.offerLast(node.right);
					}
				}
			} else {
				for (int i = 0; i < size; i++) {
					TreeNode node = deque.pollLast();
					list.add(node.val);
					if (node.right != null) {
						deque.offerFirst(node.right);
					}
					if (node.left != null) {
						deque.offerFirst(node.left);
					}
				}
			}
			res.add(list);
		}
		return res;
	}

}