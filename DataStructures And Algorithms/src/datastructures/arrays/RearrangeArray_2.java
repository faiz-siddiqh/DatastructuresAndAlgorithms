package datastructures.arrays;

import java.util.Arrays;

public class RearrangeArray_2 {
	/*
	 * Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if
	 * i is odd and j < i Input : arr[] = {1, 2, 3, 4, 5, 6, 7} Output : 4 5 3 6 2 7
	 * 1
	 */

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		rearrange(arr, arr.length);

		for (int i : arr)
			System.out.print(i + " ");

	}

	private static void rearrange(int[] arr, int n) {
		int[] output = new int[n];
		// sorting the array
		Arrays.sort(arr);
		// finding the no of even and odd positions
		int evenPos = n / 2;
		int oddPos = n - evenPos;
		int j = oddPos - 1;

		//fill odd positions in the output/temp  array
		for (int i = 0; i < arr.length; i += 2)
			output[i] = arr[j--];

		j = oddPos;
		//fill even positions in the temp array
		for (int i = 1; i < arr.length; i += 2)
			output[i] = arr[j++];

		for (int i = 0; i < arr.length; i++)
			arr[i] = output[i];

	}

}
