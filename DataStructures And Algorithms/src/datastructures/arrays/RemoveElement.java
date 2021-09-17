package datastructures.arrays;

/**
 * LEETCODE PROBLEM Given an integer array nums and an integer val, remove all
 * occurrences of val in nums in-place. The relative order of the elements may
 * be changed. Do not allocate extra space for another array. You must do this
 * by modifying the input array in-place with O(1) extra memory
 * 
 * @author Faiz-Siddiqh
 *
 */
public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		if (nums.length == 0)
			return 0;
		int count = 0;
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			if (nums[start] == val) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				end--;
			} else {
				count++;
				start++;
			}
		}
		/*
		 * for(int k=0;k<count;k++)
		 *  System.out.print(nums[k]+" ");
		 */
		return count;
	}

	public static void main(String[] args) {

		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		System.out.println(removeElement(nums, val));
	}

}
