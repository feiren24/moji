package com.algorithm;

/**
 * 归并排序（自顶向下）
 * 
 * @author linxinze
 *
 */
public class MergeSort implements BaseSort {

	@Override
	public void sort(int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		mergeSort(arr, l, r);
	}

	private void mergeSort(int[] arr, int l, int r) {
		if (l >= r)
			return;
		int mid = (l + r) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		if (arr[mid] > arr[mid + 1])
			merge(arr, l, mid, r);
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
	
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2)
            return null;
        sort(nums);
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            if(nums[left] + nums[right] < target)
                left++;
            else if(nums[left] + nums[right] > target)
                right--;
            else{
                result[0] = left;
                result[1] = right;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
    	MergeSort sort = new MergeSort();
    	int[] nums = {2,3,5,1,7,8,9};
    	sort.twoSum(nums, 8);
	}

}
