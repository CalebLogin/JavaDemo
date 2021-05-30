package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为 null
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 * @Date : 2021/4/22 21:45
 */
public class CopyRandomList138 {
    /**
     * 思路：使用hashmap
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        // 如果头节点为空，返回null
        if (head == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<>();  // 定义hash表存放原节点与新节点的对应关系
        Node newHead = new Node(head.val);  // 定义新的头节点
        map.put(head,newHead);
        Node newPrev = new Node(-1);  // 定义新链表的前驱节点
        newPrev.next = newHead;

        Node curNode = head.next;   // 定义原链表的遍历节点
        Node curNewNode = newHead;
        while (curNode != null) {
            curNewNode.next = new Node(curNode.val);
            curNewNode = curNewNode.next;
            map.put(curNode, curNewNode);
            curNode = curNode.next;
        }

        /**
         * 通过便利将原节点的random与新节点的random对应起来
         */
        curNode = head;
        while(curNode != null){
            map.get(curNode).random = map.get(curNode.random);
            curNode = curNode.next;
        }

        return newPrev.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
