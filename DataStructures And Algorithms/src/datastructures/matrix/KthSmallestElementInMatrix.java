package datastructures.matrix;

import java.util.Arrays;

/**
 * Given a N x N matrix, where every row and column is sorted in non-decreasing
 * order. Find the kth smallest element in the matrix.
 *
 */
public class KthSmallestElementInMatrix {

	/**
	 * Return Kth Smallest Element in the Matrix -Time Complexity of O(N^2logN^2)
	 * and space Complexity of N^2;
	 * 
	 * @param mat
	 * @param k
	 * @return
	 */
	private static int kthSmallestElement(int[][] mat, int k) {
		int N = mat.length;
		if (k < 0 || k > N * N)
			return -1;
		int[] arr = new int[N * N];
		int count = 0;
		// store the elements of matrix in an array and sort
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[count++] = mat[i][j];
			}
		}

		Arrays.sort(arr);

		return arr[k - 1];
	}

	public static void main(String[] args) {

		int[][] mat = { { 1, 3, 5 }, { 10, 11, 16 }, { 23, 30, 34 } };
		int k = 6;
		System.out.println(kthSmallestElement(mat, k));
	}

}
