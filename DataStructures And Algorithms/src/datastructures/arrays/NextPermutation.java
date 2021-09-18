package datastructures.arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 5, 3 };
		int n = arr.length;
		nextPermutation(arr, n);

		for (int i : arr)
			System.out.print(i + " ");

	}

	/**
	 * Very Imp : This follows the dictionary pattern and find the next possible
	 * number. Can also be applied for Strings as well
	 * 
	 * Time Complexity =O(n)+O(n)+O(n)~=O(N)
	 * 
	 * @param arr
	 * @param n
	 */
	private static void nextPermutation(int[] arr, int n) {
		// if arr has only one number or null return
		if (arr == null || n <= 1)
			return;

		// traverse from last and find the index1 where the number is less than the
		// succeeding number
		int i = n - 2;
		int index2 = n - 1;

		while (i >= 0 && arr[i] >= arr[i + 1])
			i--;

		// traverse from back till index1 and find index where the number is greater
		// than number at index1 and swap it
		if (i >= 0) {
			while (arr[index2] <= arr[i])
				index2--;
			swap(arr, i, index2);
		}

		// reverse the elements from index+1 to last of the array
		int end = n - 1;
		int start = i + 1;
		while (start < end) {
			swap(arr, start++, end--);
		}

	}

	private static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
