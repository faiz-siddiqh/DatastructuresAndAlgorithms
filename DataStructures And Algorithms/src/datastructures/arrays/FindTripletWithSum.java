package datastructures.arrays;

import java.util.Arrays;

public class FindTripletWithSum {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 4, 3, 6 };
		int n = arr.length, X = 13;

		boolean found = findTriplets(arr, n, X);
		System.out.println(found ? 1 : 0);
	}

	/**
	 * time complexity of O(n2) and space Complexity -O(1)
	 * 
	 * @param arr
	 * @param n
	 * @param x
	 * @return
	 */
	private static boolean findTriplets(int[] arr, int n, int x) {
		if (n < 2)
			return false;
		Arrays.sort(arr);

		int i, j, k;// k --> last element of array
		// traverse the array till the 2nd last element of array
		for (i = 0; i < n - 2; i++) {
			j = i + 1;
			k = n - 1;
			while (j < k) {
				// if found triplet then return true
				if (arr[i] + arr[j] + arr[k] == x)
					return true;
				// if sum is greater than required sum then decrement k
				else if (arr[i] + arr[j] + arr[k] > x)
					k--;
				// else if sum < required sum then increment j
				else
					j++;

			}

		}

		return false;
	}

	/**
	 * time complexity of O(n3) and space Complexity -O(1)
	 * 
	 * @param arr
	 * @param n
	 * @param x
	 * @return
	 */
	private static boolean findTriplet(int[] arr, int n, int x) {
		if (n < 2)
			return false;
		Arrays.sort(arr);

		int i, j, k;
		for (i = 0; i < n - 2; i++)
			for (j = i + 1; j < n - 1; j++) {
				k = j + 1;

				if (arr[k] > x)
					break;
				else if (arr[i] + arr[j] + arr[k] == x)
					return true;
				else
					k++;

			}

		return false;
	}

}
