package com.caleb.algorithm.offerdemo;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author：hanzhigang
 * @Date : 2021/3/6 5:35 PM
 */
public class OfferDemo24 {

    public ListNode reverseList(ListNode head) {
//      定义遍历节点和前序节点
        ListNode node = head;
        ListNode prev = null;
//      当遍历节点不为空时，将节点的next指向前序节点
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
//      不返回node的原因是此时node为null
        return prev;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        OfferDemo24 offerDemo24 = new OfferDemo24();
        System.out.println(offerDemo24.reverseList(node1).next.val);
    }
}
