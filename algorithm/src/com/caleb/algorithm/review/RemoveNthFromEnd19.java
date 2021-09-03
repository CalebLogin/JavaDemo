package com.caleb.algorithm.review;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-09-02 15:55:10
 * 
 *       删除链表的倒数第N个节点
 * 
 */
public class RemoveNthFromEnd19 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode curNode = head;
		ListNode preNode = head;
		ListNode deleteNode = head;
		while (curNode != null) {
			if (n > 0) {
				n--;
			} else {
				preNode = deleteNode;
				deleteNode = deleteNode.next;
			}
			curNode = curNode.next;
		}
		preNode.next = deleteNode.next;
		return deleteNode == head ? head.next : head;
	}

}