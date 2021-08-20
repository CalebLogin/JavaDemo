package com.caleb.meituan;

import com.caleb.demo.ListNode;

public class Main1 {
	
	public boolean hasCycle(ListNode head){
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast){
			if(fast == null || fast.next == null){
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
	
}
