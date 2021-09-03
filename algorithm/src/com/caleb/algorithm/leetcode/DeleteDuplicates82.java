package com.caleb.algorithm.leetcode;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-09-02 17:22:46
 * 
 *       删除排序链表中的重复元素II
 * 
 *       存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 *       返回同样按升序排列的结果链表。
 * 
 * 
 */
public class DeleteDuplicates82 {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(-1);
		ListNode preNode = pre;
		ListNode currNode = head;
		ListNode nextNode = head.next;
		while (nextNode != null) {
			if (currNode.val != nextNode.val) {
				preNode.next = currNode;
				preNode = currNode;
				currNode = nextNode;
				nextNode = currNode.next;
			} else {
				while (nextNode.next != null && nextNode.next.val == currNode.val) {
					nextNode = nextNode.next;
				}
				currNode = nextNode.next;
				nextNode = currNode.next;
			}
		}
		preNode.next = currNode;
		return pre.next;

	}
}