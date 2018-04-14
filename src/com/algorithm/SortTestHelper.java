package com.algorithm;

public class SortTestHelper {

	public static int[] getRandomArray(int number, int min, int max) {
		int[] arr = new int[number];
		for (int i = 0; i < number; i++) {
			arr[i] = (int) (Math.random() * (max - min-1) + min);
		}
		return arr;
	}
	
	public static int[] getNearlyOrderedArray(int number,int times){
		int[] arr = new int[number];
		for(int i=0;i<number;i++){
			arr[i] = i;
		}
		for(int i=0;i<times;i++){
			int randomIndex = i % number;
			int randomValue = i % number;
			arr[randomIndex] = randomValue;
		}
		return arr;
	}
	
	public static int[] copyArray(int[] arr){
		int [] dest = new int[arr.length];
		System.arraycopy(arr, 0,dest,0, arr.length);
		return dest;
	}
	public static int[] copyArray(int[] src,  int  srcPos,
             int destPos,
            int length){
			int[] dest = new int[length];
			System.arraycopy(src, srcPos,dest,0, src.length);
		return dest;
	}

	public static void main(String[] args) {
		int[] temp = getRandomArray(10, 0, 100);
		printArray(temp);
	}

	public static void swap(int[] data, int a, int b) {

		int t = data[a];

		data[a] = data[b];

		data[b] = t;

	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {
				System.out.print(",");
			}
		}
	}
	
	public static void executeSort(String sortName,BaseSort sort,int[] arr){
		Long start = System.currentTimeMillis();
		
		sort.sort(arr);
		
		Long end = System.currentTimeMillis();
		
//		printArray(arr);
		
		System.out.println("");
		System.out.println(sortName + " execute time:-----" + (start-end)/1000f );

		
	}
}
