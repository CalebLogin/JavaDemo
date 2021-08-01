package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-08-01 14:22:53
 * 
 *       二叉树的垂序遍历
 * 
 *       给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 
 *       对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col +
 *       1) 。树的根结点位于 (0, 0) 。
 * 
 *       二叉树的 垂序遍历
 *       从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 
 *       返回二叉树的 垂序遍历 序列。
 * 
 */
public class VerticalTraversal987 {

	List<List<Integer>> res;
	Map<Integer, List<Object[]>> colVisited;

	/**
	 * dfs 继续深度和col，按照深度和col排序
	 * 
	 * @param root
	 * @return
	 */
	List<int[]> nodes;

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		nodes = new ArrayList<>();
		dfs(root, 0, 0);
		Collections.sort(nodes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] == o2[1]) {
					if (o1[2] == o2[2]) {
						return o1[1] - o2[1];
					} else {
						return o1[2] - o2[2];
					}
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		List<List<Integer>> res = new ArrayList<>();
		int size = 0;
		int lastCol = Integer.MIN_VALUE;
		for (int[] i : nodes) {
			int val = i[0];
			int col = i[1];
			if (col != lastCol) {
				res.add(new ArrayList<>());
				size++;
				lastCol = col;
			}
			res.get(size - 1).add(val);
		}
		return res;
	}

	private void dfs(TreeNode node, int level, int col) {
		if (node != null) {
			nodes.add(new int[] { node.val, col, level });
			dfs(node.left, col - 1, level + 1);
			dfs(node.right, col + 1, level + 1);
		}
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(2);
		TreeNode node6 = new TreeNode(2);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		VerticalTraversal987 verticalTraversal987 = new VerticalTraversal987();
		System.out.println(verticalTraversal987.verticalTraversal(node1).toString());

	}

}