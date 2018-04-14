package com.algorithm;

public class SortTestClient {
	public static void main(String[] args) {
		BaseSort sort = new InsertionSort();
		BaseSort sort2 = new SelectionSort();
		BaseSort sort3 = new MergeSort();
		BaseSort sort4 = new MergeSortBU();
		BaseSort sort5 = new QuickSort();
		BaseSort sort6 = new QuickSort2();
		BaseSort sort7 = new MaxHeap(10000000);
		int arr[] = SortTestHelper.getRandomArray(1000000, 0, 100000);
//		int arr[] = SortTestHelper.getNearlyOrderedArray(100000, 10);
		int copyArr[] = SortTestHelper.copyArray(arr);
		int copyArr2[] = SortTestHelper.copyArray(arr);
		int copyArr3[] = SortTestHelper.copyArray(arr);
		

		SortTestHelper.executeSort("MergeSort",sort3, arr);
		SortTestHelper.executeSort("QuickSort",sort5, copyArr);
		SortTestHelper.executeSort("QuickSort2", sort6, copyArr2);
		SortTestHelper.executeSort("HeapSort", sort7, copyArr3);

	}
}
