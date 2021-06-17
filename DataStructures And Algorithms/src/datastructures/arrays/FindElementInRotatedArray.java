package datastructures.arrays;

public class FindElementInRotatedArray {

	// Search an element in a sorted and rotated array
	// O(n) =O(log n)

	private static int pivotedSearch(int[] arr, int start, int end, int key) {

		int pivot = findPivot(arr, start, end - 1);
		System.out.println(pivot);
		if (pivot == -1) {
			// The array is not rotated at all
			return binarySearch(arr, start, end - 1, key);
		}
		if (arr[pivot] == key) {
			return pivot;
		}

		if (arr[0] <= key) {
			return binarySearch(arr, start, pivot - 1, key);
		}

		return binarySearch(arr, pivot + 1, end - 1, key);
	}

	private static int binarySearch(int[] arr, int start, int end, int key) {
		if (end < start) {
			return -1;
		}
		int mid = start + (end - start) / 2;

		if (arr[mid] == key) {
			return mid;
		}
		if (arr[mid] > key) {
			return binarySearch(arr, start, mid - 1, key);
		}
		return binarySearch(arr, mid + 1, end, key);
	}

	private static int findPivot(int[] arr, int start, int end) {
		if (start > end) {
			return -1;
		}
		if (start == end) {
			return start;
		}

		int mid = start + (end - start) / 2;

		if (mid < end && arr[mid] > arr[mid + 1]) {
			return mid;
		}
		if (mid > start && arr[mid] < arr[mid - 1]) {
			return mid - 1;
		}
		if (arr[start] >= arr[mid]) {
			return findPivot(arr, start, mid - 1);
		}
		return findPivot(arr, mid + 1, end);

	}

	public static void main(String[] args) {

		int[] arr = { 1, 2,3,4, 5, 6};
		int elementToBeSearched = 5;

		int index = pivotedSearch(arr, 0, arr.length, elementToBeSearched);
		System.out.println(index);

	}

}
