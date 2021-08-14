package com.caleb.algorithm.review;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-08-14 23:36:14
 */
public class ReverseKGroup25 {

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode prev = new ListNode(-1);
		prev.next = head;
		ListNode prevNode = prev;
		ListNode node = head;
		ListNode lastNode;
		while (node != null) {
			int i = 1;
			lastNode = node;
			ListNode leftNode = lastNode;
			ListNode after;
			for (; i < k && node != null; i++) {
				node = node.next;
			}
			if (node == null) {
				after = null;
				prevNode.next = lastNode;
			} else {
				after = node.next;
				node.next = null;
				ListNode tempPre = after;
				while (leftNode != null) {
					ListNode temp = leftNode.next;
					leftNode.next = tempPre;
					tempPre = leftNode;
					leftNode = temp;
				}
				prevNode.next = node;
				prevNode = lastNode;
			}
			node = after;
		}
		return prev.next;
	}

}
