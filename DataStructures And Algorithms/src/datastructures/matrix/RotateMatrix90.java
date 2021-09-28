package datastructures.matrix;

public class RotateMatrix90 {

	/**
	 * Rotate A N*N Matrix -This approach uses the square rotation method to rotate
	 * the elements Time complexity of O(N2) and space complexity of O(1)
	 * 
	 * @param matrix
	 * @param N
	 */
	private static int[][] rotateMatrix(int[][] mat, int N) {

		for (int i = 0; i < N / 2; i++)
			for (int j = i; j < N - i - 1; j++) {

				int temp = mat[i][j];
				mat[i][j] = mat[N - j - 1][i];
				mat[N - j - 1][i] = mat[N - i - 1][N - j - 1];
				mat[N - i - 1][N - j - 1] = mat[j][N - i - 1];
				mat[j][N - i - 1] = temp;

			}
		System.out.println();
		return mat;
	}

	/**
	 * Rotate Matrix by 90 degree in clockwise direction --This approach just prints
	 * the rotated matrix indices without altering the matrix
	 * 
	 * @param matrix
	 */
	private static void rotateMatrix(int[][] matrix) {
		int n = matrix.length;
		for (int j = 0; j < n; j++) {
			for (int i = n - 1; i >= 0; i--)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

	/**
	 * Print the matrix
	 * 
	 * @param args
	 */
	public static void printMatrix(int[][] mat) {

		int n = mat.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5 }, { 10, 11, 16 }, { 23, 30, 34 } };
		printMatrix(matrix);
//		rotateMatrix(matrix);
		printMatrix(rotateMatrix(matrix, matrix.length));
	}

}
