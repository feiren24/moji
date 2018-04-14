package com.algorithm;

/**
 * 并查集第三版 使用一个数组构建一棵指向父亲节点的树，
 * 使用一个数组维护每个节点下的元素个数
 * 
 * @author linxinze
 *
 */
public class UnionFind3 {

	private int[] parent; // parent[i]表示第一个元素所指向的父节点
	private int[] sz; // sz[i]表示以i为根的集合中元素个数
	private int count; // 数据个数

	public UnionFind3(int n) {
		count = n;
		parent = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			sz[i] = 1;
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
		
		if(sz[pRoot] < sz[qRoot]){
			parent[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		}
		else{
			parent[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
	}

}
