package com.caleb.algorithm.review;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-08-14 23:36:14
 */
public class ReverseKGroup25 {

	public ListNode reverseKGroup(ListNode head, int k) {
		int i = 0;
		ListNode node = head;
		while (i < k && node != null) {
			node = node.next;
			i++;
		}
		if (i != k) {
			return head;
		}
		ListNode after = node.next;
		node.next = null;
		ListNode reNode = reverseGroup(head);
		head.next = reverseKGroup(after, k);
		return reNode;
	}

	public ListNode reverseGroup(ListNode node) {
		if (node == null) {
			return null;
		}
		if (node.next == null) {
			return node;
		}
		ListNode after = reverseGroup(node.next);
		node.next.next = node;
		node.next = null;
		return after;

	}

}
