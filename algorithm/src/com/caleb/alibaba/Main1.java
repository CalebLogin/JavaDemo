package com.caleb.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:Caleb
 * @Date :2021-08-09 19:06:49
 */
public class Main1 {

	int n = 0;

	public void isABalance() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		List<int[]> total = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
			int de = sc.nextInt();
			n = de;
			int[] vals = new int[de];
			for(int j = 0;j<de;j++){
				vals[j] = sc.nextInt();
			}
			total.add(vals);
		}
		sc.close();
		StringBuffer strb = new StringBuffer();
		for (int i = 0; i < count; i++) {
			int[] vals = total.get(i);
			n = vals.length;
			TreeNode root = build(vals);
			int next = isABalanceHelper(root);
			if (next == -1) {
				strb.append("NO\n");
			} else {
				strb.append("YES\n");
			}
		}
		System.out.print(strb.toString());
	}

	public int isABalanceHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDe = isABalanceHelper(root.left);
		int rightDe = isABalanceHelper(root.right);
		if (leftDe == -1) {
			return leftDe;
		}
		if (rightDe == -1) {
			return rightDe;
		}
		int aa = Math.min(11, n / 2);
		if (Math.abs(leftDe - rightDe) <= aa) {
			return Math.max(rightDe, leftDe) + 1;
		} else {
			return -1;
		}
	}

	public TreeNode build(int[] vals) {
		TreeNode root = new TreeNode(vals[0]);
		for (int i = 1; i < vals.length; i++) {
			TreeNode node = new TreeNode(vals[i]);
			TreeNode tempNode = root;
			while (tempNode != null) {
				if (tempNode.val > node.val) {
					if (tempNode.left == null) {
						tempNode.left = node;
						break;
					} else {
						tempNode = tempNode.left;
					}
				} else {
					if (tempNode.right == null) {
						tempNode.right = node;
						break;
					} else {
						tempNode = tempNode.right;
					}
				}
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Main1 m = new Main1();
		m.isABalance();
	}

}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode(int val) {
		this.val = val;
	}
}