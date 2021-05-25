package com.eric.alorithm.leetcode;

import com.eric.offerdemo.ListNode;

/**
 * 反转列表
 * 反转一个单链表
 * @author：hanzhigang
 * @Date : 2021/3/24 10:52 PM
 */
public class ReverseList206 {

    // 递归
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 循环
    public ListNode reverseList1(ListNode head){
        ListNode curNode = head;
        ListNode prev = null;
        while(curNode != null){
            ListNode temp = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = temp;
        }
        return prev;
    }


}
