package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-08-05 22:38:43
 */
public class LFU460 {

}

class LFUCache {

	DFNode head = new DFNode(-1, -1, Integer.MAX_VALUE);
	DFNode tail = new DFNode(-1, -1, Integer.MIN_VALUE);
	int cap = 0;
	int maxCap = 0;
	Map<Integer, DFNode> map = new HashMap<>();

	public LFUCache(int capacity) {
		this.maxCap = capacity;
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		// 如果包含该节点，返回值，并更新频率，寻找节点最合适的位置
		if (map.containsKey(key)) {
			DFNode node = map.get(key);
			node.freq++;
			updateNodePos(node);
			return map.get(key).val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if(maxCap == 0){
			return;
		}
		if (map.containsKey(key)) {
			// 如果存在该节点，更新该节点，并进行更新节点的位置
			DFNode node = map.get(key);
			node.val = value;
			node.freq++;
			updateNodePos(node);
		} else {
			// 如果超过容量，找到最近未访问的节点，然后更新过期节点的前后节点关系。
			// 之后删除哈希对应的key，然后将最新的值放到过期节点中，使其复活，并将当前节点放到尾部，并更新节点的位置
			if (cap + 1 > maxCap) {
				DFNode staleNode = tail.pre;
				staleNode.pre.next = staleNode.next;
				staleNode.next.pre = staleNode.pre;
				map.remove(staleNode.key);
				staleNode.val = value;
				staleNode.key = key;
				staleNode.freq = 1;
				map.put(key, staleNode);
				staleNode.next = tail;
				staleNode.pre = tail.pre;
				tail.pre = staleNode;
				staleNode.pre.next = staleNode;
				updateNodePos(staleNode);
			} else {
				// 未超过容量，直接新建并放到尾部，并更新节点的位置
				cap++;
				DFNode node = new DFNode(key, value, 1);
				node.next = tail;
				node.pre = tail.pre;
				tail.pre = node;
				node.pre.next = node;
				map.put(key, node);
				updateNodePos(node);
			}
		}
	}

	private void updateNodePos(DFNode node) {
		DFNode preNode = node.pre;
		node.next.pre = node.pre;
		node.pre.next = node.next;
		while (preNode.freq <= node.freq) {
			preNode = preNode.pre;
		}
		node.pre = preNode;
		node.next = preNode.next;
		preNode.next = node;
		node.next.pre = node;
	}
}

class DFNode {
	DFNode pre;
	DFNode next;
	int val;
	int key;
	int freq = 1;

	public DFNode(int key, int val, int freq) {
		this.key = key;
		this.val = val;
		this.freq = freq;
	}
}