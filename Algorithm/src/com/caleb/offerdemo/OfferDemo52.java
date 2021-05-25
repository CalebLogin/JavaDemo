package com.caleb.offerdemo;

/**
 * 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * @author：hanzhigang
 * @Date : 2021/3/14 10:28 PM
 */
public class OfferDemo52 {
    /**
     * 解题思路：如果在公共节点之前两个子链表长度不一样，通过移动一点链表的头节点将它们公共节点之前的子链表长度变相同
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//      定义两个节点作为两个链表的遍历节点
        ListNode curNode1 = headA;
        ListNode curNode2 = headB;
//      统计两个链表的长度
        int len1 = 0;
        int len2 = 0;
//      统计链表A的长度
        while (curNode1 != null) {
            ++len1;
            curNode1 = curNode1.next;
        }
//      统计链表B的长度
        while (curNode2 != null) {
            ++len2;
            curNode2 = curNode2.next;
        }
//      如果链表A长度大于链表B,则将curNode1 = headA,否则= headB
        if (len1 > len2) {
            curNode1 = headA;
            curNode2 = headB;
        }else{
            curNode1 = headB;
            curNode2 = headA;
        }
//      将curNode1指向的链表的头节点往后移动abs(len1-len2)个位置
        for(int i=0;i<Math.abs(len1-len2);i++){
            curNode1 = curNode1.next;
        }
//      当它们遍历到相同位置时，跳出循环，否则一直执行下去
        while(curNode1 != null && curNode2 != null){
            if(curNode1 == curNode2) break;
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }
//      返回公共节点或null
        return curNode1;

    }
}
