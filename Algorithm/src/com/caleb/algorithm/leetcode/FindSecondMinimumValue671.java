package com.caleb.algorithm.leetcode;

import com.caleb.demo.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-07-27 09:09:58
 * 
 *       二叉树中第二小的节点
 * 
 *       给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 
 *       更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 
 *       给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * 
 */
public class FindSecondMinimumValue671 {

	/**
	 * 递归
	 * 
	 * @param root
	 * @return
	 */
	public int findSecondMinimumValue(TreeNode root) {
		if (root.left == null) {
			return -1;
		}

		int minValue = root.val;
		int left = findSecondMinimumValueHelper(root.left, minValue);
		int right = findSecondMinimumValueHelper(root.right, minValue);
		return left == minValue ? (right == minValue ? -1 : right) : right != minValue ? Math.min(left, right) : left;
	}

	private int findSecondMinimumValueHelper(TreeNode root, int minVal) {
		if (root.val != minVal) {
			return root.val;
		} else if (root.left != null) {
			int left = findSecondMinimumValueHelper(root.left, minVal);
			int right = findSecondMinimumValueHelper(root.right, minVal);
			return left == minVal ? (right == minVal ? minVal : right) : (right != minVal ? Math.min(left, right) : left);
		}
		return minVal;
	}


	int ans;
	int rootvalue;

	public int findSecondMinimumValue1(TreeNode root) {
        ans = -1;
        rootvalue = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (ans != -1 && node.val >= ans) {
            return;
        }
        if (node.val > rootvalue) {
            ans = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		FindSecondMinimumValue671 f = new FindSecondMinimumValue671();
		System.out.println(f.findSecondMinimumValue(t1));

	}

}