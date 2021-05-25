package com.caleb.offerdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * <p>
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 考察深拷贝和浅拷贝
 *
 * @author：hanzhigang
 * @Date : 2021/3/10 10:48 PM
 */
public class OfferDemo35 {
    public Node copyRandomList(Node head) {
//      如果根结点为空，返回null
        if (head == null) {
            return null;
        }

//      映射原节点与复制节点之间的关系，便于查找和映射random
        Map<Node, Node> map1 = new HashMap<>();

        Node prev = new Node(-1);   // 定义前驱节点
        Node curNode = head;    // 遍历节点为头节点
        Node node;
        node = prev;    // 固定前驱节点，便于查找

//      当前节点不为空的情况下，复制节点，并建立next关系
        while (curNode != null) {
            Node node1 = new Node(curNode.val);
            map1.put(curNode, node1);
            prev.next = node1;
            prev = node1;
            curNode = curNode.next;
        }
//      利用hash的映射关系，建立random关系
        for (Node node1 : map1.keySet()) {
            Node newNode = map1.get(node1);
            if (node1.random != null) {
                newNode.random = map1.get(node1.random);
            }
        }

//      返回节点
        return node.next;
    }
}
