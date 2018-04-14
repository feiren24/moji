package com.algorithm;

/**
 * 最大索引堆
 * 
 * @author linxinze
 *
 */
public class IndexMaxHeap {

	private int[] data;
	private int[] indexes;
	private int[] reverse;
	private int count;
	private int capacity;

	public IndexMaxHeap(int capacity) {
		data = new int[capacity + 1];
		indexes = new int[capacity + 1];
		reverse = new int[capacity + 1];
		for (int i = 0; i <= capacity; i++) {
			reverse[i] = 0;
		}
		count = 0;
		this.capacity = capacity;
	}

	public int getSize() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean contains(int i) {
		assert i >= 0 && i < count;
		return reverse[i + 1] != 0;
	}

	/**
	 * 插入一个值
	 * 
	 * @param i
	 * @param value
	 */
	public void insert(int i, int value) {
		assert count + 1 <= capacity;
		assert i + 1 >= 1 && i + 1 <= capacity;
		assert !contains(i);

		data[i + 1] = value;
		indexes[count + 1] = i + 1;
		reverse[i + 1] = count + 1;
		count++;
		shiftUp(count);
	}

	/**
	 * 取出最大值
	 * 
	 * @return
	 */
	public int extractMax() {
		assert count > 0;
		int value = data[indexes[1]];
		swapIndexes(1, count);
		count--;
		reverse[indexes[count]] = 0;
		shiftDown(1);
		return value;
	}

	public void change(int i, int value) {
		assert contains(i);
		i += 1;
		data[i] = value;
		for(int k=1;i<=count;k++){
			if(indexes[k] == i){
				shiftUp(k);
				shiftDown(k);
				break;
			}
		}
		

	}

	public int getMax() {
		assert count > 0;
		return data[indexes[1]];
	}

	public int getMaxIndexes() {
		assert count > 0;
		return indexes[1] - 1;
	}

	public int getItem(int i) {
		assert contains(i);
		return data[i + 1];
	}

	private void swapIndexes(int i, int j) {
		int t = indexes[i];
		indexes[i] = indexes[j];
		indexes[j] = t;

		reverse[indexes[j]] = i;
		reverse[indexes[i]] = j;
	}

	private void shiftUp(int n) {
		while (n > 1 && data[indexes[n]] > data[indexes[n / 2]]) {
			swapIndexes(n, n / 2);
			n /= 2;
		}
	}

	private void shiftDown(int k) {

		while (2 * k <= count) {
			int j = 2 * k; // 在此轮循环中,data[k]和data[j]交换位置
			if (j + 1 <= count && data[indexes[j + 1]] > (data[indexes[j]]))
				j++;
			// data[j] 是 data[2*k]和data[2*k+1]中的最大值

			if (data[indexes[k]] > (data[indexes[j]]))
				break;
			swapIndexes(k, j);
			k = j;
		}
	}
	
	public void sort(int[] arr) {
		for(int i=0;i<arr.length;i++){
			insert(i,arr[i]);
		}
		for(int i=arr.length-1;i>=0;i--){
			arr[i] = extractMax();
		}
	}
	
	
	public void printHeap() {
		for (int i = 1; i <= count; i++) {
			if(i != count)
			System.out.print(data[indexes[i]] + ",");
			else{
				System.out.print(data[indexes[i]]);
				System.out.println("");
			}
				
		}
	}

	public static void main(String[] args) {
		int N = 100;
		IndexMaxHeap heap = new IndexMaxHeap(N);
		for (int i = 0; i < N; i++)
			heap.insert(i, (int) (Math.random() * N));
		heap.change(1, 9999);
		heap.change(2, 1000000);
		for(int i=0;i<N;i++){
			System.out.println(heap.extractMax());
		}
//		heap.change(1, 9999);
//		System.out.println("After change ----------------");
//		heap.printHeap();
//		int[] arr = SortTestHelper.getRandomArray(100, 0, 100);
//		heap.sort(arr);
//		for(int i=0;i<arr.length;i++){
//			System.out.println(arr[i]);
//		}
		
	}

}
