package algorithms.sortAlgorithms;

/*
 * This is NOT an in place Algorithm and its time complexity is -O(nlogn) - base 2 
 * This is a Stable Algorithm
 * Basically works by dividing and conquering the elements
 */

public class MergeSort {

	public static void main(String[] args) {

		int arr[] = { 20, 35, -15, 7, 55, 1, -55 };

		merge(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void merge(int[] arr, int start, int end) {

		if (end - start < 2) {
			return;
		}

		int mid = (start + end) / 2;

		merge(arr, start, mid);
		merge(arr, mid, end);

		mergeSort(arr, start, mid, end);

	}

	public static void mergeSort(int[] arr, int start, int mid, int end) {

		if (arr[mid - 1] <= arr[mid]) {
			return;
		}

		int i = start;
		int j = mid;
		int tempIndex = 0;

		int[] temp = new int[end - start];

		while (i < mid && j < end) {

			temp[tempIndex++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];

		}

		System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
		System.arraycopy(temp, 0, arr, start, tempIndex);

	}

}
