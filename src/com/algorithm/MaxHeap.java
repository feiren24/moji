package com.algorithm;

/**
 * 大根堆
 * 
 * @author linxinze
 *
 */
public class MaxHeap implements BaseSort{

	private int capacity;

	private int count;

	private int[] arr;

	public MaxHeap(int size) {
		arr = new int[size + 1];
		capacity = size + 1;
		count = 0;
	}
	
	public boolean isEmpty(){
		return count == 0;
	}

	/**
	 * 插入一个值
	 * 
	 * @param value
	 */
	public void insert(int value) {
		assert count <= capacity + 1;
		arr[count + 1] = value;
		count++;
		shiftUp(count);
	}

	/**
	 * 拿出最大值
	 * 
	 * @return
	 */
	public int extractMax() {
		assert count > 0;

		int max = arr[1];

		// 数组最后一个值与第一个交换
		swap(1, count);
		count--;
		shiftDown2(1);
		return max;
	}

	private void shiftDown2(int index) {

		int k = calculatePosition(index);

		while (2* index <= count) {
			if(arr[index] > arr[k]) break;
			swap(index, k);
			index = k;
			k = calculatePosition(index);
		}
	}

	private void shiftDown(int k) {

		while (2 * k <= count) {
			int j = 2 * k; // 在此轮循环中,data[k]和data[j]交换位置
			if (j + 1 <= count && arr[j + 1] > (arr[j]))
				j++;
			// data[j] 是 data[2*k]和data[2*k+1]中的最大值

			if (arr[k] > (arr[j]) )
				break;
			swap(k, j);
			k = j;
		}
	}

	// 计算需要比较的叶子节点的下标
	private int calculatePosition(int index) {
		int p = 0;
		if (index < count) {
			p = 2 * index;
			if (2 * index + 1 <= count && arr[p] < arr[2 * index + 1]) {
				p = 2 * index + 1;
			}
		}
		return p;
	}

	private void shiftUp(int n) {
		while (n > 1 && arr[n] > arr[n / 2]) {
			swap(n, n / 2);
			n /= 2;
		}
	}

	public void printHeap() {
		for (int i = 1; i <= count; i++) {
			System.out.println(arr[i]);
		}
	}

	public int getSize() {
		return count;
	}

	private void swap(int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	@Override
	public void sort(int[] arr) {
		for(int i=0;i<arr.length;i++){
			insert(arr[i]);
		}
		for(int i=arr.length-1;i>=0;i--){
			arr[i] = extractMax();
		}
	}

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(10);
//		for (int i = 1; i <= 10; i++) {
//			heap.insert(i);
//		}
//		heap.printHeap();
//		int count = heap.getSize();
//		for (int i = 1; i <= count; i++) {
//			int max = heap.extractMax();
//			System.out.println(max);
//		}
		
		int[] a = {2,3,4,5,1,7,6,8,9,10};
		heap.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}

	}
}
