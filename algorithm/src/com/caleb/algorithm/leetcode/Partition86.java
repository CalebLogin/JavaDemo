package com.caleb.algorithm.leetcode;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-09-02 19:24:31
 * 
 *       分割链表
 * 
 *       给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 
 *       你应当 保留 两个分区中每个节点的初始相对位置。
 * 
 */
public class Partition86 {

	public ListNode partition(ListNode head, int x) {
		ListNode node = head;
		ListNode l1 = new ListNode(-1);
		ListNode pre1 = l1;
		ListNode l2 = new ListNode(-1);
		ListNode pre2 = l2;
		while (node != null) {
			if (node.val < x) {
				l1.next = node;
				l1 = l1.next;
			} else {
				l2.next = node;
				l2 = l2.next;
			}
			node = node.next;
		}
		l1.next = null;
		l2.next = null;
		l1.next = pre2.next;
		return pre1.next;
	}
}