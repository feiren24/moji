package com.algorithm;

/**
 * 并查集第四版 
 * @author linxinze
 *
 */
public class UnionFind4 {

	private int[] parent; // parent[i]表示第一个元素所指向的父节点
	private int[] rank; // rank[i]表示以i为根的集合所表示树的层次
	private int count; // 数据个数

	public UnionFind4(int n) {
		count = n;
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
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
		
		if(rank[pRoot] < rank[qRoot]){
			parent[pRoot] = qRoot;
		}
		else if(rank[pRoot] > rank[qRoot]){
			parent[qRoot] = pRoot;
		}
		else{
			parent[pRoot] = qRoot;
			rank[qRoot] += 1;
		}
	}

}
