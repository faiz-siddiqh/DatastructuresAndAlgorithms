package datastructures.arrays;

/**
 * LEETCODE PROBLEM
 * 
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The
 * relative order of the elements should be kept the same.
 * Do not allocate extra space for another array. You must do this by modifying the input array
 * in-place with O(1) extra memory.
 * 
 * @author Faiz-Siddiqh
 *
 */
public class FindDuplicatesInSortedArray {
	
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int count = 1;
		int cur = nums[0];
		int len = nums.length;
		boolean flag = true;

		for (int i = 1; i < len && flag; i++) {

			if (nums[i] <= cur) {
				int j = i + 1;
				while (j < len && flag) {
					if (nums[j] > cur) {
						nums[i] = nums[j];
						count++;
						cur = nums[i];
						break;
					}
					j++;
					if (j == len)//no greater element is found in the array ,right to nums[i]
						flag = false;
				}

			} else {//element is unique ,so move to next element and increment the count
				count++;
				cur = nums[i];
			}

		}
		// Printing Sorted elements
		for (int k = 0; k < count; k++)
			System.out.print(nums[k] + " ");

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6 };
		int sorted = removeDuplicates(nums);
		// System.out.println("The length of sorted UNIQUE elements in the array is " +
		// sorted);
	}

}
