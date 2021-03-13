package com.eric.offerdemo;

/**
 * @author：hanzhigang
 * @Date : 2021/3/12 7:40 PM
 */
public class Solution {
    /**
     * 合并两个升序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergerTwoList(ListNode l1, ListNode l2) {

//       如果一个链表为空，返回另一个
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode prev = new ListNode(-1);     // 遍历节点
        ListNode curNode = prev;    // 前序节点，记录头节点
        ListNode c1 = l1, c2 = l2;
//      当两个链表都不为空时，比较当前节点的值，prev指向小的节点
        while (c1 != null && c2 != null) {
            if (c1.val > c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
//      如果有一个链表不为空，将升序的链表与另一个链表拼接
        prev.next = c1 != null ? c1 : c2;
//      返回结果
        return curNode.next;
    }

    public static void main(String[] args) {

    }
}
