package com.caleb.tencent;

/**
 * @author:Caleb
 * @Date :2021-09-08 19:24:22
 */
public class Main5 {

}

interface MyMap {
	int size();// 哈希大小

	Object get(Object key);// 取值

	Object put(Object key, Object value);// 存值

	interface Entry<K, V> {
		K getKey();

		V getValue();
	}

}

class MyHashMap implements MyMap {

	// 初始大小
	private static int INIT_SIZE = 1 << 4;

	private static Node[] nodes = new Node[INIT_SIZE];

	private int size = 0;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		int hashCode = key.hashCode();
		int index = finHash(hashCode, nodes.length);
		Node node = null;
		if (nodes[index] == null) {
			return null;
		}
		for (node = nodes[index]; node != null; node = node.next) {
			if (node.getKey().equals(key)) {
				return node.getValue();
			}
		}
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		int hashCode = key.hashCode();
		int index = finHash(hashCode, nodes.length);
		Node node = null, pre = null;
		if (nodes[index] == null) {
			node = new Node();
			node.nodeKey = key;
			node.nodeValue = value;
			nodes[index] = node;
			size++;
			return value;
		}
		for (node = nodes[index], pre = node; node != null && !node.nodeKey.equals(key); pre = node, node = node.next)
			;
		if (node == null) {
			node = new Node();
			node.nodeKey = key;
			node.nodeValue = value;
			pre.next = node;
			return value;
		} else {
			Object oldV = node.nodeValue;
			node.nodeValue = value;
			return oldV;
		}
	}

	private int finHash(int hashCode, int len) {
		return hashCode % len;
	}

	static class Node implements MyMap.Entry {

		int hash;

		Object nodeKey;

		Object nodeValue;

		Node next;

		@Override
		public Object getKey() {
			// TODO Auto-generated method stub
			return this.nodeKey;
		}

		@Override
		public Object getValue() {
			// TODO Auto-generated method stub
			return this.nodeValue;
		}

	}

}