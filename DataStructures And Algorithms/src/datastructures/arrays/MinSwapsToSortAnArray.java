package datastructures.arrays;

import java.util.Arrays;

public class MinSwapsToSortAnArray {

	public static void main(String[] args) {
		int[] a = { 1, 5, 4, 3, 2 };
		System.out.println(minSwaps(a));
	}

	public static int minSwaps(int nums[]) {
		int []temp = Arrays.copyOfRange(nums, 0, nums.length);
		Arrays.sort(temp);
		int count = 0;
		for (int i = 0; i < nums.length;) {

			if (nums[i] != temp[i]) {
				count++;
				swap(nums, i, findIndex(temp,nums[i]));

			}
			if (nums[i] == temp[i]) {
				i++;
			}

		}

		return count;
	}

	public static void swap(int[] arr, int i, int j) {

		int num = arr[i];
		arr[i] = arr[j];
		arr[j] = num;
	}

	public static int findIndex(int [] temp,int key) {

		for (int i = 0; i < temp.length; i++)
			if (temp[i] == key)
				return i;
		
		
		return -1;
	}

}
