package com.algorithm;

public class QuickSort3 implements BaseSort {

	@Override
	public void sort(int[] arr) {
		int l = 0;
		int r = arr.length -1;
		quickSort(arr,l,r);
	}
	
	
	private void quickSort(int[] arr,int l,int r){
		if(l >= r)
			return;
		
		int randIndex  = (int) (Math.random() * (r - l-1) + l);
		SortTestHelper.swap(arr, l, randIndex);

		int flag = arr[l];

		int lt = l; //arr[l+1...lt] < v
		int gt = r+1;//arr[gt...r] > v
		int i = l + 1;//arr[lt+1,i) == v
		
		while(i < gt){
			if(arr[i] < flag){
				SortTestHelper.swap(arr, i, lt+1);
				lt++;
				i++;
			}
			else if(arr[i] > flag){
				SortTestHelper.swap(arr, i, gt-1);
				gt--;
			}
			else{
				i++;
			}
		}
		SortTestHelper.swap(arr, l, lt);
		
		quickSort(arr,l,lt-1);
		quickSort(arr,gt,r);
		
	}
	
	public static void main(String[] args) {
		int arr[] = {5,6,3,5,2,7,5,5,4,1,9,8};
	    QuickSort3 sort = new QuickSort3();
		sort.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	
	}


}
