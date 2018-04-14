package com.algorithm;

/**
 * 快速排序1（使用单一扫描）
 * @author linxinze
 *
 */
public class QuickSort implements BaseSort {

	@Override
	public void sort(int[] arr) {

		int l = 0;
		int r = arr.length -1;
		
		quickSort(arr,l,r);

	}
	
	private void quickSort(int[] arr,int l, int r){
		if(l >= r)
			return;
		int p = partition(arr,l,r);
		quickSort(arr,l,p-1);
		quickSort(arr,p+1,r);
	}
	
	
	private int partition(int[] arr, int l, int r){
		int randIndex  = (int) (Math.random() * (r - l-1) + l);
		SortTestHelper.swap(arr, l, randIndex);
		int flag = arr[l];
		int j = l;
		for(int i=l+1;i<=r;i++){
			if(arr[i] < flag){
				j++;
				SortTestHelper.swap(arr, j,i);
			}
		}
		SortTestHelper.swap(arr, l, j);
		
		return j;
	}
	
	public static void main(String[] args) {
		int arr[] = {7,6,3,5,2,4,1,9,8};
	    QuickSort sort = new QuickSort();
		sort.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
