package com.caleb.algorithm.datastructure;

public class QuickUnion {

	int[] root;
	int[] rank;

	public QuickUnion(int size) {
		root = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) {
			root[i] = -1;
			rank[i] = 1;
		}
	}

	public int find(int x) {
		if (root[x] == x) {
			return x;
		}
		return root[x] = find(root[x]);
	}

	public void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot != yRoot) {
			if (rank[xRoot] > rank[yRoot]) {
				root[yRoot] = xRoot;
			} else if (rank[xRoot] < rank[yRoot]) {
				root[xRoot] = yRoot;
			} else {
				root[xRoot] = yRoot;
				rank[yRoot]++;
			}

		}
	}

	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}
}
