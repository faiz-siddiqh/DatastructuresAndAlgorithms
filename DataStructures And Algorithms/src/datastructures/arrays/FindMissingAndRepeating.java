package datastructures.arrays;

import java.util.HashSet;

/*
 * Given an unsorted array Arr of size N of positive integers.
 *  One number 'A' from set {1, 2, …N} is missing and one number 'B'
 *  occurs twice in array. Find these two numbers
 */
public class FindMissingAndRepeating {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2 };
		arr = findTwoElement(arr, arr.length);
		System.out.println("Repeating number is " + arr[0] + " and missing number is " + arr[1]);
	}

	static int[] findTwoElement(int arr[], int n) {
		int[] ar = new int[2];
		HashSet<Integer> set = new HashSet<>();

		for (int i : arr) {
			if (set.contains(i)) {
				ar[0] = i;
			}
			set.add(i);
		}

		for (int i = 1; i <= arr.length; i++) {
			if (!set.contains(i)) {
				ar[1] = i;
				break;
			}
		}

		return ar;
	}

}
