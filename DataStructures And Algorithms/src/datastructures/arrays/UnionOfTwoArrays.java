package datastructures.arrays;

public class UnionOfTwoArrays {

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 5, 9 };
		int arr2[] = { 2, 3, 5, 7 };
		int m = arr1.length;
		int n = arr2.length;

		printUnion(arr1, arr2, m, n);
		System.out.println();
		printIntersection(arr1, arr2, m, n);

	}

	private static void printUnion(int[] arr1, int[] arr2, int n, int m) {

		for (int i : arr1)
			System.out.print(i + " ");

		for (int i = 0; i < m; i++) {
			int key = binarySearch(arr1, 0, n - 1, arr2[i]);
			if (key == -1) {
				System.out.print(arr2[i] + " ");
			}

		}

	}

	private static void printIntersection(int[] arr1, int[] arr2, int n, int m) {

		for (int i = 0; i < m; i++) {
			int key = binarySearch(arr1, 0, n - 1, arr2[i]);
			if (key == 1) {
				System.out.print(arr2[i] + " ");
			}

		}

	}

	private static int binarySearch(int[] arr1, int l, int n, int key) {

		while (n >= l) {

			int mid = (l + n) / 2;
			if (arr1[mid] == key)
				return 1;

			if (arr1[mid] > key)
				return binarySearch(arr1, l, mid - 1, key);

			else
				return binarySearch(arr1, mid + 1, n, key);
		}
		return -1;
	}

}
