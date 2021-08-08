package com.caleb.algorithm.leetcode;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author：hanzhigang
 * @Date : 2021/3/28 10:23 PM
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode curNode1 = prev;
        int add = 0; // 记录进位
        prev.next = l1;
        while (l1 != null && l2 != null) {
            curNode1 = l1;
            int sum = l1.val + l2.val+add;
            add = sum / 10;
            l1.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            curNode1 = l1;
            int sum = l1.val + add;
            add = sum / 10;
            l1.val = sum % 10;
            l1 = l1.next;
        }
        if(l2 != null){
            curNode1.next = l2;
        }
        while(l2 != null){
            curNode1 = l2;
            int sum = l2.val + add;
            add = sum / 10;
            l2.val = sum % 10;
            l2 = l2.next;
        }
        if(add != 0){
            ListNode last = new ListNode(add);
            curNode1.next = last;
        }
        return prev.next;
    }
}
