package com.caleb.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.caleb.algorithm.offerdemo.ListNode;

/**
 * 合并K个升序链表
 * @author：hanzhigang
 * @Date : 2021/4/5 9:30 PM
 */
public class MergeKLists23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null){
            return null;
        }
        int leftSize = 0;
        for(int i = 0;i<lists.length;i++){
            if(lists[i] != null){
                leftSize++;
            }
        }
        if(leftSize == 0){
            return null;
        }
        if(leftSize == 1){
            for(ListNode listNode : lists){
                if(listNode != null){
                    return listNode;
                }
            }
        }

        ListNode preNode = new ListNode(Integer.MAX_VALUE);
        ListNode curNode = preNode;
        ListNode min;
        while(true){
            min = preNode;
            int index = 0;
            int i = 0;
            for(;i<lists.length;i++){
                if(lists[i] != null && min.val >= lists[i].val){
                    min = lists[i];
                    index = i;
                }
            }
            System.out.println(lists[index].val);
            curNode.next = lists[index];
            lists[index] = lists[index].next;
            if(lists[index] == null){
                leftSize--;
            }
            curNode = curNode.next;
            if(leftSize==1){
                break;
            }

        }
        for(ListNode listNode : lists){
            if(listNode != null){
                curNode.next = listNode;
                break;
            }
        }
        return preNode.next;

    }

    /**
     * 优先队列的思想
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode listNode:lists){
            if(listNode != null){
                priorityQueue.add(listNode);
            }
        }
        ListNode preNode = new ListNode(-1);
        ListNode curNode = preNode;
        while(!priorityQueue.isEmpty()){
            ListNode temp = priorityQueue.poll();
            curNode.next = temp;
            curNode = curNode.next;
            if(temp.next != null){
                priorityQueue.add(temp.next);
            }
        }
        return preNode.next;
    }

    /**
     * 分治合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists){
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int left,int right){
        if(left == right){
            return lists[left];
        }
        if(left > right){
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoList(merge(lists,left,mid),merge(lists,mid+1,right));
    }

    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode prevNode = new ListNode(-1);
        ListNode curNode = prevNode;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                curNode.next = head1;
                head1 = head1.next;
            }else{
                curNode.next = head2;
                head2 = head2.next;
            }
            curNode = curNode.next;
        }
        if(head1 != null){
            curNode.next = head1;
        }

        if(head2 != null){
            curNode.next = head2;
        }
        return prevNode.next;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(6);
        listNode7.next = listNode8;
        ListNode[] lists = new ListNode[]{listNode1,listNode4,listNode7};
        MergeKLists23 mergeKLists23 = new MergeKLists23();
        ListNode res = mergeKLists23.mergeKLists(lists);
        while(res != null){
            System.out.print(res.val+"--");
            res = res.next;
        }

    }
}
