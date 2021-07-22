package datastructures.matrix;

import java.util.Arrays;

public class SortAllElementsInMatrix {

	public static void main(String[] args) {
		int mat[][] = { { 5, 4, 7 }, { 1, 3, 8 }, { 2, 9, 6 } };
		int n = 3;

		System.out.println("Original Matrix:");
		printMat(mat, n);

		sortMatrix(mat, n);

		System.out.println("Matrix After Sorting:");
		printMat(mat, n);
	}

	/**
	 * This method takes a time complexity of O(N^2LogN) and space complexity of
	 * O(N^2)
	 * 
	 * @param Mat
	 * @param N
	 */
	private static void sortMatrix(int[][] Mat, int N) {
		int[] arr = new int[N * N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[count++] = Mat[i][j];
			}
		}

		Arrays.sort(arr);
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Mat[i][j] = arr[count++];
			}
		}

	}

	private static void printMat(int[][] mat, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

}
