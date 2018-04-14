package com.algorithm;

/**
 * 归并排序（自底向上）
 * @author linxinze
 *
 */
public class MergeSortBU implements BaseSort{

	@Override
	public void sort(int[] arr) {
		for(int sz=1;sz<=arr.length;sz+=sz){
			for(int i=0;i+sz<arr.length;i+=sz+sz){
				merge(arr,i,i+sz-1,Math.min(i+sz+sz-1, arr.length -1));
			}
		}
	}
	
	
	
	private void merge(int[] arr, int l, int mid, int r) {
		int[] copyArr = new int[r - l + 1];
		for (int i = l; i <= r; i++) {
			copyArr[i - l] = arr[i];
		}
		int i = l;
		int j = mid + 1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				arr[k] = copyArr[j - l];
				j++;
			} else if (j > r) {
				arr[k] = copyArr[i - l];
				i++;
			} else if (copyArr[i - l] < copyArr[j - l]) {
				arr[k] = copyArr[i - l];
				i++;
			} else {
				arr[k] = copyArr[j - l];
				j++;
			}
		}
	}


}
