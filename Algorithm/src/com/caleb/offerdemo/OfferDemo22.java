package com.caleb.offerdemo;

/**
 * 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * @author：hanzhigang
 * @Date : 2021/3/5 2:30 PM
 */
public class OfferDemo22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
//      链表的长度
        int length = 0;
//      访问元素的位置
        int index = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        if(k<=0 || k > length){
            return null;
        }
        length = length - k;
        node = head;
        while(index < length){
            node = node.next;
            index++;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        OfferDemo22 offerDemo22 = new OfferDemo22();
        System.out.println(offerDemo22.getKthFromEnd(node1, 2).val);

    }
}
