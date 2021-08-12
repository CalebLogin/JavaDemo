package com.caleb.algorithm.offerdemo;

/**
 * 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 * 思路：使用双指针遍历链表
 * @author：hanzhigang
 * @Date : 2021/3/6 5:51 PM
 */
public class OfferDemo25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//      定义新的遍历时使用的节点
        ListNode res = new ListNode(-1);
//      定义新的节点保存真实链表中头节点的前序节点
        ListNode head = res;
//      当两个链表都没有遍历结束时，一直进行遍历合并的操作
        while(l1 != null && l2 != null){
//          如果l1节点的值小于l2节点的值，res.next指向l1
            if(l1.val < l2.val){
                res.next = l1;
                l1 = l1.next;
            }else{
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        res.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
