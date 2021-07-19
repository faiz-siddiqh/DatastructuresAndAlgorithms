package datastructures.matrix;

import java.util.Arrays;

/**
 * Given a sorted matrix ,Find a target a element in the matrix
 * 
 * @author Faiz-Siddiqh
 *
 */
public class SearchAElementInMatrix {

	public static void main(String[] args) {
//		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int[][] matrix = { { 1, 2, 13, 13, 22, 28 }, { 31, 33, 34, 34, 36, 38 }, { 40, 48, 49, 51, 52, 53 },
				{ 55, 56, 59, 60, 60, 60 }, { 61, 63, 63, 64, 67, 70 }, { 62, 63, 64, 66, 68, 71 } };
		int target = 62;
		System.out.println(searchElement(matrix, 1, 6, target));
		System.out.println(searchTargetElement(matrix, 1, 6, target));
	}

	/**
	 * This method has a time complexity of O(n*m) and space complexity of O(1)and
	 * is a efficient way
	 * 
	 * @param matrix
	 * @param n
	 * @param m
	 * @param target
	 * @return
	 */
	private static int searchTargetElement(int[][] matrix, int n, int m, int target) {
		if (matrix.length == 0)
			return 0;
		int low = 0;
		int high = (m * n) - 1; // The total/highest possibilities of checks are rows*columns -1

		while (low <= high) {

			int mid = (low + high) / 2;
			// The middle element is given by [mid/noOfColumns]and [mid%noOfColumns]
			if (matrix[mid / m][mid % m] == target)
				return 1;
			else if (matrix[mid / m][mid % m] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return 0;
	}

	/**
	 * Using this method not all testcases pass.Not recommended to use .
	 * 
	 * @param matrix
	 * @param N
	 * @param M
	 * @param X
	 * @return
	 */
	private static int searchElement(int[][] matrix, int N, int M, int X) {
		if (X < matrix[0][0] || X > matrix[N - 1][M - 1]) {
			return 0;
		}

		return binaryMatrixSearch(matrix, 0, N, M - 1, X);
	}

	private static int binaryMatrixSearch(int[][] matrix, int start, int N, int M, int X) {

		int mid = (start + N) / 2;
		if (matrix[mid][0] > X && matrix[mid - 1][M] < X) {
			return 0;
		} else if (matrix[mid][0] <= X && matrix[mid][M] >= X) {
			return search(matrix, mid, M, X);
		} else if (matrix[mid - 1][M] >= X) {
			return binaryMatrixSearch(matrix, start, mid - 1, M, X);
		} else {
			return binaryMatrixSearch(matrix, mid, N, M, X);
		}
	}

	private static int search(int[][] matrix, int N, int M, int X) {
		int found = 0;
		int mid = M / 2;
		if (matrix[N][M] == X) {
			return 1;
		}
		if (matrix[N][mid] == X) {
			found = 1;
		} else if (matrix[N][mid] > X) {
			found = search(matrix, N, mid - 1, X);
		} else if (matrix[N][M] < X)
			found = search(matrix, mid, M, X);

		return found;
	}

}
