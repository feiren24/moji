package com.algorithm;

/**
 * 并查集
 * 第一版 非树形结构
 * @author linxinze
 *
 */
public class UnionFind1 {
	private int[] ids;
	private int count;

	public UnionFind1(int n){
		count = n;
		ids = new int[n];
		for(int i=0;i<n;i++){
			ids[i] = i;
		}
	
	}
	
	public int find(int p){
        assert p >= 0 && p < count;
        return ids[p];		
	}
	
	public boolean isConnected(int p, int q){
		return find(p) == find(q);
	}
	
	public void unionElements(int p, int q){
		int pId = find(p);
		int qId = find(q);
		
		if(pId == qId)
			return;
		for(int i=0;i<count;i++){
			if(find(i) == pId){
				ids[i] = qId;
			}
		}
	}
	
	
	
	
	
	
}
