package com.caleb.alorithm.leetcode;

import com.caleb.offerdemo.ListNode;

/**
 * K个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author：hanzhigang
 * @Date : 2021/3/24 11:21 PM
 */
public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 链表的长度
        int len = 0;
        // 一共分几组
        int group = 0;
        ListNode curNode = head;
        ListNode tailNode = null;
        ListNode nextNode = null;
        // 前驱节点，指向头节点
        ListNode prevNode = new ListNode(-1);
        prevNode.next = head;
        // 统计组数
        while (curNode != null) {
            ++len;
            curNode = curNode.next;
        }
        group = len / k;

        ListNode prev = prevNode;
        for (int i = k * group; i > 0; i -= k) {
            prev = prevNode;
            curNode = head;
            int count = 0;
            while (count < i - k) {
                prev = curNode;
                curNode = curNode.next;
                ++count;
            }
            tailNode = prev;
            while (count < i) {
                tailNode = tailNode.next;
                nextNode = tailNode.next;
                ++count;
            }
            prev.next = reverseList(nextNode, curNode);


        }
        return prev.next;

    }

    public ListNode reverseKGroup1(ListNode head, int k) {

        // 链表的长度
        int len = 0;

        // 当前节点、尾节点、后继节点
        ListNode curNode = head;
        ListNode tailNode = null;
        ListNode nextNode = null;

        // 前驱节点，指向头节点
        ListNode prevNode = new ListNode(-1);
        prevNode.next = head;
        // 计算长度
        while (curNode != null) {
            ++len;
            curNode = curNode.next;
        }

        ListNode prev = prevNode;
        curNode = head;

        for (int i = k; i < len; i += k) {
            System.out.println(i);
            int count = 0;
            tailNode = prev;
            while (count < k) {
                tailNode = tailNode.next;
                nextNode = tailNode.next;
                ++count;
            }

            prev.next = reverseList(nextNode, curNode);
            int size = 0;
            while(size < k){
                prev = prev.next;
                size++;
            }
            curNode = nextNode;


        }
        return prevNode.next;

    }

    /**
     * 翻转k个链表
     *
     * @param nextNode
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode nextNode, ListNode head) {
        ListNode prevNode = nextNode;
        ListNode curNode = head;
        while (curNode != nextNode) {
            ListNode temp = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = temp;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ReverseKGroup25 reverseKGroup25 = new ReverseKGroup25();
        ListNode temp = reverseKGroup25.reverseKGroup1(listNode1, 2);
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }

    }
}
