package algorithms.sortAlgorithms;

public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = { 20, -12, 3, 55, -22, 32, 13 };

		for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

			int largestElement = 0;

			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if (arr[i] > arr[largestElement])
					largestElement = i;

			}

			swap(arr, largestElement, lastUnsortedIndex);

		}

		System.out.println("Array after sorting :");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void swap(int[] arr, int i, int j) {

		if (i == j) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
