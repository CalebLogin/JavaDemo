package com.caleb.algorithm.leetcode;

import com.caleb.offerdemo.ListNode;

/**
 * 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * @author：hanzhigang
 * @Date : 2021/6/5 9:54 AM
 */
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = pre.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return preHead.next;
    }
}
