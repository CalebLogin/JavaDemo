package com.caleb.algorithm.yidian;

import com.caleb.algorithm.leetcode.TreeNode;
import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-08-31 10:44:58
 * 
 *       反转单向链表
 * 
 */
public class Main {

	public ListNode reverse(ListNode head) {
		// 前缀节点
		ListNode currPre = null;
		ListNode currNode = head;
		while (currNode != null) {
			ListNode next = currNode.next;
			currNode.next = currPre;
			currPre = currNode;
			currNode = next;
		}
		return currPre;
	}

	public boolean isValid(TreeNode root){
		return isValidHelper(root,root);
	}

	public boolean isValidHelper(TreeNode left,TreeNode right){
		if(left == null && right == null){
			return true;
		}
		if(left != null && right != null){
			return left.val == right.val && isValidHelper(left.left,right.right) && isValidHelper(left.right, right.left);
		}

		return false;
	}

}