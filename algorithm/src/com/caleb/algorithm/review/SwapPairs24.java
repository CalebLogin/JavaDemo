package com.caleb.algorithm.review;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-09-02 16:22:04
 */
public class SwapPairs24 {

	public ListNode swapPairs(ListNode head) {
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode preNode = pre;
		ListNode currNode = head;
		ListNode after = head;
		while (currNode != null) {
			int i = 0;
			ListNode node = currNode;
			while (node != null && i < 2) {
				after = node;
				node = node.next;
				i++;
			}
			if (i != 2) {
				break;
			}
			after = node;
			currNode.next.next = currNode;
			pre.next = currNode.next;
			currNode.next = after;
			pre = currNode;
			currNode = after;
		}
		return preNode.next;
	}

}