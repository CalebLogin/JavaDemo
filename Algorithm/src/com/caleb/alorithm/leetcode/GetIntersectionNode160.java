package com.caleb.alorithm.leetcode;

import com.caleb.offerdemo.ListNode;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点
 *
 * @author：hanzhigang
 * @Date : 2021/3/25 6:36 PM
 */
public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 定义两个节点分别指向两个链表的头节点
        ListNode curNodeA = headA;
        ListNode curNodeB = headB;

        // 两个链表的长度
        int lenA = 0;
        int lenB = 0;

        // 统计两个链表的长度
        while (curNodeA != null) {
            ++lenA;
            curNodeA = curNodeA.next;
        }
        while(curNodeB != null){
            ++lenB;
            curNodeB = curNodeB.next;
        }

        // 始终让curNodeA指向数组最长的那个链表
        if(lenA < lenB){
            int temp = lenA;
            lenA = lenB;
            lenB = temp;
            curNodeA = headB;
            curNodeB = headA;
        }else{
            curNodeA = headA;
            curNodeB = headB;
        }

        while(lenA != lenB){
            --lenA;
            curNodeA = curNodeA.next;
        }

        while(curNodeA != null && curNodeB != null && curNodeA != curNodeB){
            curNodeA = curNodeA.next;
            curNodeB = curNodeB.next;
        }

        return curNodeA;

    }
}
