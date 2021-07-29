package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-07-29 10:16:02
 * 
 *       二叉树寻路
 * 
 *       在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * 
 *       如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 
 *       而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 * 
 */
public class PathInZigZagTree1104 {

	public List<Integer> pathInZigZagTree(int label) {
		List<Integer> res = new ArrayList<>();
		if (label == 1) {
			res.add(1);
			return res;
		}
		int i = 1;
		while ((Math.pow(2, i) - 1) < label) {
			i++;
		}

		/**
		 * 如果当前层即 i 为偶数，则需要找到当前节点对应完全二叉树的当前位置的节点。 如果当前层即 i
		 * 为奇数，则需要找到上一层完全二叉树的节点对应的规则改变后的节点位置
		 */
		while (i > 1) {
			// 当前节点上面的所有节点个数，也是上一层最右节点
			int topCount = (int) Math.pow(2, i - 1) - 1;
			// 完全二叉树下当前层最右节点
			int currRightCount = (int) Math.pow(2, i) - 1;

			res.add(label);

			// 如果偶数
			if (i % 2 == 0) {
				while (label != topCount + 1 && currRightCount != label) {
					topCount++;
					currRightCount--;
				}
				if (topCount + 1 == label) {
					label = currRightCount;
				} else {
					label = topCount + 1;
				}
				label /= 2;
			} else {
				// 完全二叉树形态下应该对应的节点
				int lastNode = label / 2;
				// 上一层的节点个数
				int lastCount = (int) Math.pow(2, i - 2);
				// 上一层最左节点
				int left = topCount - lastCount + 1;
				while (left != lastNode && topCount != lastNode) {
					left++;
					topCount--;
				}
				if (left == lastNode) {
					label = topCount;
				} else {
					label = left;
				}
			}
			i--;

		}
		res.add(1);
		Collections.reverse(res);
		return res;
	}

	public List<Integer> pathInZigZagTree1(int label) {
		List<Integer> res = new ArrayList<>();
		if (label == 1) {
			res.add(1);
			return res;
		}
		int i = 1;
		while ((Math.pow(2, i) - 1) < label) {
			i++;
		}
		if (i % 2 == 0) {
			label = getReverse(label, i);
		}
		while (i > 0) {
			if (i % 2 == 0) {
				res.add(getReverse(label, i));
			} else {
				res.add(label);
			}
			i--;
			label >>= 1;
		}
		Collections.reverse(res);
		return res;
	}

	public int getReverse(int label, int row) {
		return (1 << (row - 1)) + (1 << row) - 1 - label;
	}

	public static void main(String[] args) {
		PathInZigZagTree1104 p = new PathInZigZagTree1104();
		System.out.println(p.pathInZigZagTree1(14));
	}

}