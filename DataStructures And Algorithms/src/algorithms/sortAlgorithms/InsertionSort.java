package algorithms.sortAlgorithms;

public class InsertionSort {

	public static void main(String[] args) {

		int[] arr = { 20, -12, 3, 55, -22, 32, 13 };

		for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {

			int newElement = arr[firstUnsortedIndex];

			int i;

			for (i = firstUnsortedIndex; i > 0 && arr[i - 1] > newElement; i--)
				arr[i] = arr[i - 1];

			arr[i] = newElement;

		}

		System.out.println("Array after sorting :");

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}

}
