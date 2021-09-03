package com.caleb.algorithm.review;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-09-02 16:16:20
 * 
 *       合并K个升序链表
 * 
 */
public class MergeKLists23 {

	public ListNode mergeKLists(ListNode[] lists) {
		return mergeKListsHelper(lists, 0, lists.length - 1);
	}

	public ListNode mergeKListsHelper(ListNode[] lists, int i, int j) {
		if (i > j) {
			return null;
		}
		if (i == j) {
			return lists[i];
		}
		int mid = i + (j - i) / 2;
		ListNode ll = mergeKListsHelper(lists, i, mid);
		ListNode rr = mergeKListsHelper(lists, mid + 1, j);
		return mergeLists(ll, rr);
	}

	public ListNode mergeLists(ListNode l1, ListNode l2) {
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
		if (l1 != null) {
			preNode.next = l1;
		}
		if (l2 != null) {
			preNode.next = l2;
		}
		return pre.next;
	}

}