package com.algorithm;



/***
 * 选择排序
 * @author linxinze
 *
 */
public class SelectionSort implements BaseSort{

	public static void main(String[] args) {
		BaseSort sort = new SelectionSort();
		int arr[] = SortTestHelper.getRandomArray(1000, 0, 1000);
		SortTestHelper.executeSort("selectionSort",sort, arr);
	}
	
	public  void sort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int minIndex = 0;
			minIndex = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[minIndex]>arr[j]){
					minIndex = j;
				}
			}
			SortTestHelper.swap(arr,i,minIndex);
		}
	}
	





}
