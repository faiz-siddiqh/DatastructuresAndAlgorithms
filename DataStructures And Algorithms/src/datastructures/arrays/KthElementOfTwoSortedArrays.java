package datastructures.arrays;

import java.util.Arrays;

public class KthElementOfTwoSortedArrays {

	public static void main(String[] args) {
		int arr1[] = { 2, 3, 6, 7, 9 };
		int arr2[] = { 1, 4, 8, 10 };
		int n = arr1.length;
		int m = arr2.length;
		int k = 5;
		// System.out.println(kthElementSol1(arr1, arr2, n, m, k));
		System.out.println(kthElementSol2(arr1, arr2, n, m, k));

	}

	/**
	 * This method is an optimised approach,with time complexity of O(n)and space
	 * complexity of O(m+n)
	 * 
	 * @param arr1
	 * @param arr2
	 * @param n
	 * @param m
	 * @param k
	 * @return
	 */
	private static long kthElementSol2(int[] arr1, int[] arr2, int n, int m, int k) {
		int temp[] = new int[m + n];
		int i = 0;
		int j = 0;
		int count = 0;

		while (i < n && j < m)
			temp[count++] = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++];

		while (i < n)
			temp[count++] = arr1[i++];
		while (j < m)
			temp[count++] = arr2[j++];

		return temp[k - 1];
	}

	/**
	 * This method has a complexity of O((n*logn)*n).And must be optimised
	 * 
	 * @param arr1
	 * @param arr2
	 * @param n
	 * @param m
	 * @param k
	 * @return
	 */
	public static long kthElementSol1(int arr1[], int arr2[], int n, int m, int k) {

		for (int i = 0; i < n; i++) {
			if (arr1[i] > arr2[0]) {
				swap(arr1, arr2, i);
				Arrays.sort(arr2);
			}
		}

		if (k <= n)
			return arr1[k - 1];
		else
			k = k - n - 1;

		return arr2[k];

	}

	public static void swap(int[] arr1, int[] arr2, int i) {
		int temp = arr1[i];
		arr1[i] = arr2[0];
		arr2[0] = temp;
	}

}
