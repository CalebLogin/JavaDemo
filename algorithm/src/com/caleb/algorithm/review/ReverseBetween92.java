package com.caleb.algorithm.review;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-08-14 23:18:55
 * 
 *       反转链表II
 * 
 *       给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置
 *       right 的链表节点，返回 反转后的链表 。
 * 
 */
public class ReverseBetween92 {

	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode prev = new ListNode(-1);
		prev.next = head;
		ListNode after;
		ListNode node = head;
		ListNode leftNode;
		ListNode rightNode;
		int pos = 1;
		while (left != pos) {
			node = node.next;
			prev = prev.next;
			pos++;
		}
		leftNode = node;
		while (right != pos) {
			node = node.next;
			pos++;
		}
		rightNode = node;
		after = node.next;
		prev.next = null;
		rightNode.next = null;
		while (leftNode != null) {
			ListNode temp = leftNode.next;
			leftNode.next = after;
			after = leftNode;
			leftNode = temp;
		}
		prev.next = rightNode;
		if (left == 1) {
			return prev.next;
		} else {
			return head;
		}

	}

}