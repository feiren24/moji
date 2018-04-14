package com.algorithm;

/**
 * 并查集第二版 使用一个数组构建一棵指向父亲节点的树
 * 
 * @author linxinze
 *
 */
public class UnionFind2 {

	private int count;
	private int[] parent;

	public UnionFind2(int n) {
		count = n;
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public int find(int p) {
		assert (p >= 0 && p < count);
		// 不断去查询自己的父亲节点, 直到到达根节点
		// 根节点的特点: parent[p] == p
		while (p != parent[p])
			p = parent[p];
		return p;
	}

	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if (pRoot == qRoot)
			return;

		parent[pRoot] = qRoot;
	}

}
