package com.caleb.algorithm.leetcode;
import com.caleb.offerdemo.ListNode;
/**
 * 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * @author: Caleb
 * @Date  : 2021-05-25 13:17:48
 * ============================
 */

public class DeleteNode237 {

	public void deleteNode(ListNode node) {
		ListNode prev = new ListNode(-1);
		ListNode curr = node;
		ListNode nextNode = curr.next;
		prev.next = curr;
		while (nextNode != null) {
			prev = curr;
			curr.val = nextNode.val;
			curr = nextNode;
			nextNode = curr.next;
		}
		prev.next = null;
	}

	public static void main(String[] args) {
		System.out.println("");
	}
}