package com.algorithm;

/**
 * 插入排序
 * @author linxinze
 *
 */
public class InsertionSort implements BaseSort{

	@Override
	public void sort(int[] arr) {
		for(int i=1;i<arr.length;i++){
			int value = arr[i];
			int position = i;
			for(int j=i;j>0 && value < arr[j-1];j--){
				arr[j] = arr[j-1]; 
				position = j-1;
			}
			if(position != i)
			arr[position] = value;
		}
	}
	
	

}
