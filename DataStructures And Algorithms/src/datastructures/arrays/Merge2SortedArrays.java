package datastructures.arrays;

import java.util.Arrays;

public class Merge2SortedArrays {

	public static void main(String[] args) {

		int arr1[] = { 1, 3, 5, 7 };
		int arr2[] = { 0, 2, 6, 8, 9 };
		int n = arr1.length;
		int m = arr2.length;

		merge_Sol1(arr1, arr2, n, m);
		merge_Sol2(arr1, arr2, n, m);

	}

	/**
	 * This method has a time complexity of O(n*m) .here temp[] is used only to
	 * print .So space complexity is O(1)
	 * 
	 * @param arr1
	 * @param arr2
	 * @param n
	 * @param m
	 */
	private static void merge_Sol2(int[] arr1, int[] arr2, int n, int m) {
		int[] temp = new int[m + n];

		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] > arr2[0]) {
				swap(arr1, arr2, i, 0);
				Arrays.sort(arr2);
			}
		}

		int count = 0;

		for (int i = 0; i < arr1.length; i++)
			temp[count++] = arr1[i];

		for (int j = 0; j < arr2.length; j++)
			temp[count++] = arr2[j];

		for (int i : temp)
			System.out.print(i + " ");

	}

	private static void swap(int[] arr1, int[] arr2, int i, int j) {
		System.out.println("To swap" + arr1[i] + " " + arr2[j]);
		int temp = arr1[i];
		arr1[i] = arr2[j];
		arr2[j] = temp;
	}

	/**
	 * This method has time Complexity of O(NlogN) +O(N)+O(N)
	 * 
	 * @param arr1
	 * @param arr2
	 * @param n
	 * @param m
	 */
	private static void merge_Sol1(int[] arr1, int[] arr2, int n, int m) {

		int temp[] = new int[m + n];
		int count = 0;
		for (int i = 0; i < arr1.length; i++)
			temp[count++] = arr1[i];

		for (int j = 0; j < arr2.length; j++)
			temp[count++] = arr2[j];

		// Implement merge or Quick Sort.
		Arrays.sort(temp);

		for (int i : temp)
			System.out.print(i + " ");

	}

}
