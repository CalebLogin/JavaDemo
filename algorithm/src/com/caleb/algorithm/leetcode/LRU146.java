package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRU146 {

}

/**
 * 使用哈希表 + 双向链表
 */
class LRUCache {

	DNode head = new DNode(-1,-1);
	DNode tail = new DNode(-1,-1);
	int cap = 0;
	int maxCap = 0;
	Map<Integer, DNode> map = new HashMap<>();

	public LRUCache(int capacity) {
		this.maxCap = capacity;
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DNode node = map.get(key);
			node.pre.next = node.next;
			node.next.pre = node.pre;
			node.pre = head;
			node.next = head.next;
			head.next = node;
			node.next.pre = node;
			return map.get(key).val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			// 如果存在该节点，更新该节点，并把该节点放到头部
			DNode node = map.get(key);
			node.val = value;
			node.pre.next = node.next;
			node.next.pre = node.pre;
			node.pre = head;
			node.next = head.next;
			head.next = node;
			node.next.pre = node;
		} else {
			// 如果超过容量，找到最近未访问的节点，然后更新过期节点的前后节点关系。
			// 之后删除哈希对应的key，然后将最新的值放到过期节点中，使其复活，并将当前节点放到头部
			if (cap + 1 > maxCap) {
				DNode staleNode = tail.pre;
				staleNode.pre.next = staleNode.next;
				staleNode.next.pre = staleNode.pre;
				map.remove(staleNode.key);
				staleNode.val = value;
				staleNode.key = key;
				map.put(key, staleNode);
				staleNode.pre = head;
				staleNode.next = head.next;
				head.next = staleNode;
				staleNode.next.pre = staleNode;
			} else {
				// 未超过容量，直接新建并放到头部
				cap++;
				DNode node = new DNode(key,value);
				node.pre = head;
				node.next = head.next;
				head.next = node;
				node.next.pre = node;
				map.put(key, node);
			}
		}
	}
}

class DNode {
	DNode pre;
	DNode next;
	int val;
	int key;

	public DNode(int key,int val) {
		this.val = val;
		this.key = key;
	}
}
