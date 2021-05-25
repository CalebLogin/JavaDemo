package com.caleb.alorithm.leetcode;

import com.caleb.offerdemo.ListNode;

/**
 * 排序链表
 * 给你链表的头结点head，请将其按 升序 排列并返回排序后的链表 。
 * <p>
 * 进阶：
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * @author: hanzhigang
 * @Date : 2021/4/26 20:26
 */
public class SortList148 {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);

    }

    private ListNode sortList(ListNode l, ListNode r) {
        if (l == null) {
            return l;
        }
        if (l.next == r) {
            l.next = null;
            return l;
        }

        ListNode fastNode = l, slowNode = l;
        ListNode mid;
        while(fastNode != r){

            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if(fastNode != r){
                fastNode = fastNode.next;
            }

        }
        mid = slowNode;
        ListNode left = sortList(l,mid);
        ListNode right = sortList(mid.next,r);
        return merge(left, right);

    }

    /**
     * 对两段有序链表进行合并
     *
     * @param l
     * @param r
     * @return
     */
    private ListNode merge(ListNode l, ListNode r) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return head.next;
    }
}
