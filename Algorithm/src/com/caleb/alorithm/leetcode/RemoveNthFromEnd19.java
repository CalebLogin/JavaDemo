package com.caleb.alorithm.leetcode;

import com.caleb.offerdemo.ListNode;

/**
 * @author：hanzhigang
 * @Date : 2021/4/4 6:59 PM
 */
public class RemoveNthFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curNode = head;    // 遍历节点，由首节点一直遍历到尾节点
        ListNode prevNode = head;   // 指向删除节点的前驱节点
        ListNode deleteNode = head; // 删除节点，最终指向被删除的节点

        while(curNode != null){
            if(n > 0){
                n--;
            }else{
                prevNode = deleteNode;
                deleteNode = deleteNode.next;
            }
            curNode = curNode.next;
        }
        prevNode.next = deleteNode.next;
        return deleteNode == head ? head.next : head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd19 removeNthFromEnd19 = new RemoveNthFromEnd19();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode head = removeNthFromEnd19.removeNthFromEnd(listNode1,5);
        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }

    }
}
