package datastructures.arrays;

public class SortArrayWith0s1s2s {
	/*
	 * Sort an array of 0s, 1s and 2s
	 */
	public static void main(String[] args) {
		int arr[] = { 0, 2, 1, 2, 0 };
		int n = arr.length;
		sortArray(arr, n - 1);

		for (int i : arr)
			System.out.print(i + " ");

	}

	private static void sortArray(int[] arr, int n) {

		int i = 0;
		int low = 0;
		int high = n;
		int temp;

		while (i <= high) {

			switch (arr[i]) {

			case 0:
				temp = arr[i];
				arr[i] = arr[low];
				arr[low] = temp;
				low++;
				i++;
				break;

			case 1:
				i++;
				break;

			case 2:
				temp = arr[i];
				arr[i] = arr[high];
				arr[high] = temp;
				high--;
				break;

			}

		}

	}

}
