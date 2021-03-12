package com.eric.offerdemo;

/**
 * 删除链表的节点
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点
 *
 * @author：hanzhigang
 * @Date : 2021/3/4 10:59 PM
 */
public class OfferDemo18 {

    public ListNode deleteNode(ListNode head, int val) {

//      头节点为空时，返回null
        if (head == null) return null;
//      删除的节点为头节点时，返回头节点的下一个节点
        if (head.val == val) return head.next;
//      preNode指向头节点，curNode指向头节点的下一个节点
        ListNode preNode = head;
        ListNode curNode = head.next;
//      curNode不为空且值不等于val时，持续向下查找
        while (curNode != null && curNode.val != val) {
            preNode = curNode;
            curNode = preNode.next;
        }
//      若curNode遍历到最后时，未找到符合条件节点
//      若找到符合条件的节点，删除curNode
        preNode.next = (curNode == null) ? null : curNode.next;
//      返回头节点
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        OfferDemo18 offerDemo18 = new OfferDemo18();
        System.out.println(offerDemo18.deleteNode(node1, 1).next.next.val);
    }
}
