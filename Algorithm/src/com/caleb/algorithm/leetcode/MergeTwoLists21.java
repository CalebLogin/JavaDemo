package com.caleb.algorithm.leetcode;

import com.caleb.offerdemo.ListNode;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 10:55 PM
 */
public class MergeTwoLists21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode curNode = prev;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        if (l1 != null) curNode.next = l1;
        if (l2 != null) curNode.next = l2;
        return prev.next;
    }
}
