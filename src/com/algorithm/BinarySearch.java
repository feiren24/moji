package com.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
	
	
    public static  int binarySearch(int[] nums, int target) {
        // write your code here
        int l = 0;
        int r = nums.length-1;
        return search2(nums,l,r,target);
    }
    
    public static List<Integer> getSum(int[] nums, int value){
    	List<Integer> list = new ArrayList<Integer>();
    	
    	
    	//使用二分查找
    	if(nums == null || nums.length < 2)
    		return null;
    	for(int i=0;i<nums.length;i++){
    		int target = value - nums[i];
    		if(i<nums.length){
    			int result = search2(nums,++i,nums.length-1,target);
    			if(result != -1){
    				list.add(i-1);
    				list.add(result);
    			}
    		}
    		
    	}
    	
    	//对撞指针写法
    	
    	
    	
    	return list;
    }

	public static int search(int[] arr,int l, int r,int target){
        int mid = l + (r-l)/2;
        
		if(arr[mid]  == target){
			for(int i=mid-1;i>=l;i--){
				if(arr[i] == target){
					mid--;
				}
			}
			return mid;

		}
		
		if(l >= r){
			return -1;
		}
			
					
		if(arr[mid] > target){
			mid = search(arr,l,mid-1,target);
		}
		else if(arr[mid] < target){
			mid = search(arr,mid+1,r,target);
		}
		else{
			mid = -1;
		}
		return mid;
		
	}
	
	public static int search2(int[] arr,int l,int r,int target){
		
		while(l <= r){
			int mid = (l+r)/2;
			if(arr[mid] == target)
				return mid;
			if(arr[mid] > target)
				r = mid-1;
			else{
				l = mid +1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {4,5,9,9,12,13,14,15,15,18};
		int position = binarySearch(arr,21);
		System.out.println(position);
		
		List<Integer> list = getSum(arr, 33);
		System.out.println(list);
		
	}
}
