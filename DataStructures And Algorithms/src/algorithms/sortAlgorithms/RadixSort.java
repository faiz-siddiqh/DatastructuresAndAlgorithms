package algorithms.sortAlgorithms;

public class RadixSort {

	// Radix Sort is also called bucket sort. The idea of Radix Sort is to do digit
	// by digit sort starting from least significant digit to most significant
	// digit. Radix sort uses counting sort as a subroutine to sort.

	/*
	 * Time Complexity- O(n+K) -n is number of elements and K is the width of the
	 * largest number
	 */
	public static void main(String[] args) {

		int[] arr = { 34, 4, 543, 46, 77, 4, 65, 424, 566, 676, 1, 10, 989, 300 };
		int n = arr.length;
		radixSort(arr, n);
	}

	private static void radixSort(int[] arr, int n) {

		int max = getMax(arr, n);
		for (int pass = 1; max / pass > 0; pass = pass * 10) {
			countSort(arr, pass, n);
		}

		for (int i : arr) {
			System.out.print(i + "  ");
		}
	}

	private static void countSort(int[] arr, int pass, int n) {

		int[] temp = new int[10]; // As we are dealing with digits ,the range is 0-9 i.e 10 digits
		int[] output = new int[n];
		for (int i = 0; i < n; i++) {

			temp[(arr[i] / pass) % 10]++;
		}
		for (int i = 1; i < temp.length; i++) {

			temp[i] += temp[i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {

			output[--temp[(arr[i] / pass) % 10]] = arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}

	}

	private static int getMax(int[] arr, int length) {
		int max = arr[0];
		for (int i = 1; i < length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}

		return max;
	}

}
