package com.caleb.algorithm.leetcode;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * 两两交换链表中的节点
 * 
 * @author:Caleb
 * @Date :2021-06-18 14:17:02
 */
public class SwapPairs24 {

	/**
	 * 递归
	 * 
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head != null) {
			int count = 0; // 记录遍历节点的个数
			ListNode prevNode = new ListNode(-1);
			ListNode currNode = prevNode;
			prevNode.next = head;
			while (currNode != null && count < 2) {
				currNode = currNode.next;
				count++;
			}
			if (currNode == null) {
				return head;
			} else {
				prevNode.next = swapPairs(currNode.next);
				currNode.next = null;
				swapPairsHelper(head);
				head.next = prevNode.next;
				return currNode;
			}

		}
		return null;
	}

	/**
	 * 反转链表
	 * @param head
	 * @return
	 */
	private ListNode swapPairsHelper(ListNode head) {
		if (head.next == null) {
			return head;
		} else {
			ListNode currNode = swapPairsHelper(head.next);
			currNode.next = head;
			head.next = null;
			return head;
		}
	}

	public static void main(String[] args) {
		SwapPairs24 swapPairs24 = new SwapPairs24();
		ListNode listnode1 = new ListNode(1);
		ListNode listnode2 = new ListNode(2);
		ListNode listnode3 = new ListNode(3);
		ListNode listnode4 = new ListNode(4);
		listnode1.next = listnode2;
		listnode2.next = listnode3;
		listnode3.next = listnode4;
		ListNode finalNode = swapPairs24.swapPairs(listnode1);
		while(finalNode != null){
			System.out.println(finalNode.val);
			finalNode = finalNode.next;
		}
	}

}