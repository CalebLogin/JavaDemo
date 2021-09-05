package com.caleb.tencent;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * @author:Caleb
 * @Date :2021-09-05 20:54:25
 */
public class Main2 {

	public ListNode solve(ListNode[] a) {
		// write code here
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		boolean hasNotNull = true;
		while (hasNotNull) {
			hasNotNull = false;
			for (int i = 0; i < a.length; i++) {
				ListNode node = a[i];
				if (node != null) {
					hasNotNull = true;
				}
				if(node == null){
					continue;
				}
				cur.next = node;
				cur = cur.next;
				node = node.next;
				a[i] = node;
			}
		}
		return dummy.next;
	}

}