package datastructures.matrix;

/**
 * https://leetcode.com/problems/rotate-image/
 * 
 * @author Faiz-Siddiqh You are given an n x n 2D matrix representing an image,
 *         rotate the image by 90 degrees (clockwise).
 * 
 *         You have to rotate the image in-place, which means you have to modify
 *         the input 2D matrix directly. DO NOT allocate another 2D matrix and
 *         do the rotation.
 */
public class LC_Rotate_Image_48 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Original Matrix");
		printMatrix(matrix);
		System.out.println("Rotated Image Matrix");
		rotate(matrix);
		printMatrix(matrix);

	}

	private static void rotate(int[][] matrix) {

		// Transpose the matrix -first

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <= i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;

			}
		}

		// Reverse the rows

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				int temp = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}

	}

	/**
	 * Method to print A Matrix
	 * 
	 * @param matrix
	 */
	private static void printMatrix(int matrix[][]) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}
	}

}
