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

    /**
     * 两两反转
     *
     * @param root
     * @return
     */
    public static ListNode reverseList(ListNode root) {
//      当空节点或一个节点的时候，返回root
        if (root == null || root.next == null) {
            return root;
        }

//      虚拟前置节点，前置的节点,当前节点，下一个节点
        ListNode prevv = new ListNode(-1);
        ListNode prev = root, curNode = root.next, afterNode;
        prevv.next = prev;
//      头节点
        ListNode head = root.next;

//      当前节点不为空时，至少存在偶数个节点
        while (curNode != null) {
            prevv.next = curNode;
            afterNode = curNode.next;
            prev.next = afterNode;
            curNode.next = prev;
            prevv = prev;
            prev = afterNode;
            if (prev != null) {
                curNode = prev.next;
            } else {
                break;
            }
        }
        return head;
    }

    public static ListNode reverseListNode(ListNode root) {
        if (root == null) return null;
        if (root.next == null) return root;
        ListNode curNode = root.next;
        root.next = reverseList(curNode.next);
        curNode.next = root;
        return curNode;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        l5.next = l6;
        ListNode node = reverseListNode(l1);
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }
}
