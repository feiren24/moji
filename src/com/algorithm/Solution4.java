package com.algorithm;

class Solution4 {

	//使用指针碰撞
	
	public  static int[] separateOddEvenNumbers(int[] nums) {
		int front = 0;
		int tail = nums.length-1;
		while(front < tail){
			//如果是偶数
			if(nums[tail] % 2 == 0){
				tail--;
			}
			//如果是奇数
			if(nums[front] % 2 != 0){
				front ++;
			}
			
			int temp = nums[front];
			nums[front] = nums[tail];
			nums[tail] = temp;
			
			front++;
			tail--;
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		separateOddEvenNumbers(nums);
	}

}