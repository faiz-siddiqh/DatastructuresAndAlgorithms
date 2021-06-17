package datastructures.arrays;

public class MaximumSumOfRotatedArray {

	public static void main(String[] args) {

		MaximumSumOfRotatedArray ar = new MaximumSumOfRotatedArray();
		int arr[] = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(ar.findMaxSum(arr, arr.length));
	}

	private int findMaxSum(int[] arr, int length) {
		int sum = 0;

		int pivot = findPivot(arr);

		// the diff of pivot from the end of the array
		int diff = length - 1 - pivot;

		for (int i = 0; i < arr.length; i++) {

			sum = sum + ((diff + i) % length) * arr[i];
		}

		return sum;
	}

	private int findPivot(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[i + 1])
				return i;
		}

		return 0;// then it is a sorted array
	}

}
