package datastructures.matrix;

public class SpiralTraversalOfMatrix {

	public static void main(String[] args) {
		int r = 4;
		int c = 4;
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		spirallyTraverseMatrix(matrix, r, c);
	}

	/**
	 * This approach has a time complexity of O(rc) and spaceComplexity of O(1)
	 * 
	 * @param matrix
	 * @param r
	 * @param c
	 */
	private static void spirallyTraverseMatrix(int[][] matrix, int r, int c) {

		int k = 0; // variable to track the rows
		int m = r; // variable to track the last row
		int l = 0;// variable to keep track of columns from first
		int n = c; // columns from last

		while (k < m && l < n) {
			int i;

			// Printing the matrix from left to right
			for (i = l; i < n - 1; i++)
				System.out.print(matrix[l][i] + " ");

			// printing the matrix from top right to bottom
			for (i = k; i < m - 1; i++)
				System.out.print(matrix[i][n - 1] + " ");
			// printing the matrix from bottom right to left
			for (i = n - 1; i > l; i--)
				System.out.print(matrix[m - 1][i] + " ");

			// printing the matrix from the left bottom to top left
			for (i = m - 1; i > k; i--)
				System.out.print(matrix[i][l] + " ");

			// incrementing and decrementing the values of the variables
			k++;
			l++;
			n--;
			m--;
		}
	}

}
