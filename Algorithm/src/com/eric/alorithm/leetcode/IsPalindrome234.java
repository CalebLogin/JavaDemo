package com.eric.alorithm.leetcode;

import com.eric.offerdemo.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题
 *
 * @author: hanzhigang
 * @Date : 2021/5/24 20:03
 */
public class IsPalindrome234 {
    /**
     * 使用list
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (!list.get(i).equals(list.get(size - i - 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 快慢指针
     * 反转链表
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }



//      找到前半段的尾节点
        ListNode medianNode = medianListNode(head);
//      反转链表
        ListNode reversedListNode = reverseList(medianNode.next);
        while (reversedListNode != null) {
            if (head.val != reversedListNode.val) {
                return false;
            }
            head = head.next;
            reversedListNode = reversedListNode.next;
        }
        return true;

    }

    private ListNode medianListNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode currNode = head;
        ListNode nextNode;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        IsPalindrome234 isPalindrome234 = new IsPalindrome234();
        System.out.println(isPalindrome234.isPalindrome1(l1));
    }

}
