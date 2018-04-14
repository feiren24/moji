package com.algorithm;

/**
 * 并查集第五版 
 * @author linxinze
 *
 */
public class UnionFind5 {
	
	// rank[i]表示以i为根的集合所表示的树的层数
    // 在后续的代码中, 我们并不会维护rank的语意, 也就是rank的值在路径压缩的过程中, 有可能不在是树的层数值
    // 这也是我们的rank不叫height或者depth的原因, 他只是作为比较的一个标准
    // 关于这个问题，可以参考问答区：http://coding.imooc.com/learn/questiondetail/7287.html
	private int[] rank;
	private int[] parent; // parent[i]表示第一个元素所指向的父节点
	private int count; // 数据个数

	public UnionFind5(int n) {
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
		while (p != parent[p]){
			parent[p] = parent[parent[p]]; 
			p = parent[p];
		}
			
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
