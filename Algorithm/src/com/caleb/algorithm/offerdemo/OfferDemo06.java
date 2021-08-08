package com.caleb.algorithm.offerdemo;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author：hanzhigang
 * @Date : 2021/3/2 9:22 AM
 */
public class OfferDemo06 {

    public int[] reversePrint(ListNode head) {

        int[] a;
        int length = 0;
        ListNode node = head;

//      遍历链表，得到元素个数
        while(node != null){
            length++;
            node = node.next;
        }
//      新建int[]
        a = new int[length];
        length--;

//      再重新遍历链表，按照逆序将元素添加到数组中
        while(head != null){
            a[length] = head.val;
            length--;
            head = head.next;
        }

        return a;
    }

    public int[] reversePrint1(ListNode head) {

        Stack<Integer> stack = new Stack<Integer>();
        int[] a;
        ListNode curNode = head;
        int length = 0;
        while(curNode != null){
            length++;
            stack.push(curNode.val);
            curNode = curNode.next;
        }

        curNode = head;
        a = new int[length];
        length--;
        while(curNode != null){
            a[length] = curNode.val;
            length--;
            curNode = curNode.next;
        }

        return a;
    }
}
