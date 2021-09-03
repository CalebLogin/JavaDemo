package com.caleb.algorithm.leetcode;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-09-02 16:58:12
 * 
 *       旋转链表
 * 
 *       给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class RotateRight61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (k == 0 || head == null || head.next == null) {
			return head;
		}
		int len = 1;
		ListNode currNode = head;
		while (currNode.next != null) {
			currNode = currNode.next;
			len++;
		}
		System.out.println(len);
		int n = len - k % len;
		if (n == len) {
			return head;
		}
		currNode.next = head;
		currNode = head;
		while (n-- > 1) {
			currNode = currNode.next;
		}
		ListNode newHead = currNode.next;
		currNode.next = null;
		return newHead;
	}

}