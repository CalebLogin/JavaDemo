package com.caleb.algorithm.leetcode;

import com.caleb.demo.ListNode;

/**
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * @author:Caleb
 * @Date  :2021-06-14 11:34:58
 */
public class OddEvenList328{

	/**
	 * 双指针
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		/**
		 * 奇节点
		 */
		ListNode odd = head,even = head.next;
		ListNode prev = new ListNode(-1,odd);
		ListNode preveven = new ListNode(-1,even);
		int count = 0;
		while(odd.next != null && even.next != null){
			if(count % 2 == 0){
				odd.next = even.next;
				odd = odd.next;
			}else{
				even.next = odd.next;
				even = even.next;
			}
			count++;
		}
		even.next = null;
		odd.next = null;
		odd.next = preveven.next;
		
		return prev.next;

    }
	public static void main(String[] args) {
		ListNode listnode1 = new ListNode(1);
		ListNode listnode2 = new ListNode(2);
		ListNode listnode3 = new ListNode(3);
		ListNode listnode4 = new ListNode(4);
		ListNode listnode5 = new ListNode(5);
		listnode1.next = listnode2;
		listnode2.next = listnode3;
		listnode3.next = listnode4;
		listnode4.next = listnode5;
		OddEvenList328 oddEvenList328 = new OddEvenList328();
		ListNode res = oddEvenList328.oddEvenList(listnode1);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}

}