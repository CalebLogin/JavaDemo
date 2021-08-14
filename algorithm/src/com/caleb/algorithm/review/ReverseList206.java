package com.caleb.algorithm.review;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-08-14 23:10:55
 * 
 *       反转链表
 * 
 *       给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 
 */
public class ReverseList206 {

	ListNode preNode = new ListNode(-1);

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode node = reverseListHelper(head);
		node.next = null;
		return preNode.next;
	}

	private ListNode reverseListHelper(ListNode head) {
		if (head.next == null) {
			preNode.next = head;
		} else {
			ListNode nextNode = reverseListHelper(head.next);
			nextNode.next = head;
		}

		return head;

	}

}