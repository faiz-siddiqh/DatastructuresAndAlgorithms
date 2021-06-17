package datastructures.arrays;

public class MultipleLeftRotationsOfArray {
	// Quickly find multiple left rotations of an array for given k times
	public static void main(String[] args) {
		MultipleLeftRotationsOfArray mul = new MultipleLeftRotationsOfArray();
		int[] arr = { 7, 6, 1, 2, 3, 4, 5, 6 };
		int n = arr.length;
		// creating a array of twice the length and copying array twice
		int[] temp = new int[2 * n];

		mul.preprocess(arr, temp, n);
		int k = 3;
		mul.rotate(arr, k, n, temp);
		mul.rotate(arr, 5, n, temp);

		// another method which is space effective
		mul.rotate(arr, 3, n);

	}

	private void preprocess(int[] arr, int[] temp, int n) {
		for (int i = 0; i < arr.length; i++) {
			temp[i] = temp[i + n] = arr[i];
		}

	}

	private void rotate(int[] arr, int d, int n, int[] temp) {
		int start = d % n;
		for (int i = start; i < start + n; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}

	// This is a spaced optimised approach
	private void rotate(int[] arr, int k, int n) {
		for (int i = k; i < k + n; i++)
			System.out.print(arr[i % n] + " ");

	}

}
