package com.caleb.algorithm.review;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-09-02 16:10:10
 * 
 *       合并两个有序链表
 * 
 */
public class MergeTwoLists21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode preNode = new ListNode(-1);
		ListNode pre = preNode;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				preNode.next = l1;
				l1 = l1.next;
			} else {
				preNode.next = l2;
				l2 = l2.next;
			}
			preNode = preNode.next;
		}
		if(l1 != null){
			preNode.next = l1;
		}
		if(l2 != null){
			preNode.next = l2;
		}
		return pre.next;
	}

}