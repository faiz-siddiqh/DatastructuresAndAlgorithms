package datastructures.arrays;

public class FindKthSmallestElement {

	public static void main(String[] args) {

		int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
		int n = arr.length, k = 5;

		System.out.println(findKthSmallest(arr, 0, n-1, k));

	}

	private static int findKthSmallest(int[] arr, int start, int end, int k) {

		while (k > 0 && k <=end - start + 1) {

			int pos = quickSortPivot(arr, start, end);
			if (pos == k - 1)
				return arr[pos];

			if (pos > k - 1)
				return findKthSmallest(arr, start, pos - 1, k);

			return findKthSmallest(arr, pos + 1, end, k);

		}
		return Integer.MAX_VALUE;
	}

	private static int quickSortPivot(int[] arr, int start, int end) {

		int mid = arr[start + end / 2];

		while (start < end) {

			while (arr[start] < mid)
				start++;

			while (arr[end] > mid)
				end--;

			if (start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}

		}

		return start;
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

}
