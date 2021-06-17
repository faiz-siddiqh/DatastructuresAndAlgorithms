package datastructures.arrays;

public class FindDuplicatesInArray {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
		int arr_size = arr.length;

		// printRepeating(arr, arr_size);) //O(nlogn *n-1)
		printRepeating_Sol2(arr, arr_size); // O(n)

	}

	private static void printRepeating_Sol2(int[] arr, int n) {

		for (int i = 0; i < n; i++) {

			arr[arr[i] % n] = arr[arr[i] % n] + n;
		}

		for (int i = 0; i < n; i++)
			if (arr[i] > 2 * n)
				System.out.print(i + " ");
	}

	private static void printRepeating(int[] arr, int n) {

		for (int i = 0; i < n - 1; i++) {
			int result = binarySearch(arr, i + 1, n - 1, arr[i]);
			if (result == 1)
				System.out.print(arr[i] + " ");
		}

	}

	private static int binarySearch(int[] arr, int start, int end, int key) {
		if (end < start) {
			return -1;
		}
		int mid = start + (end - start) / 2;

		if (arr[mid] == key) {
			return 1;
		}
		if (arr[mid] > key) {
			return binarySearch(arr, start, mid - 1, key);
		}
		return binarySearch(arr, mid + 1, end, key);
	}
}
