package com.caleb.algorithm.review;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-08-14 23:18:55
 * 
 *       反转链表II
 * 
 *       给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置
 *       right 的链表节点，返回反转后的链表。
 * 
 */
public class ReverseBetween92 {

	public ListNode reverseBetween(ListNode head, int left, int right) {
		int l = 1;
		int r = left;
		ListNode node1 = head;
		ListNode pre1 = new ListNode(-1);
		ListNode pre = pre1;
		pre1.next = head;
		while (l < left) {
			pre1 = node1;
			node1 = node1.next;
			l++;
		}
		pre1.next = null;
		ListNode node2 = node1;
		ListNode pre2 = node2;
		while (r < right-1) {
			pre2 = node2;
			node2 = node2.next;
			r++;
		}
		pre2.next = null;
		pre1.next = reverseList(node1);
		node1.next = node2;
		return pre.next;
	}

	public ListNode reverseList(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}
		ListNode finalNode = reverseList(node.next);
		node.next.next = node;
		node.next = null;
		return finalNode;
	}

}