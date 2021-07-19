package datastructures.matrix;

public class SpiralTraversalOfMatrix {

	public static void main(String[] args) {
		int r = 3;
		int c = 5;
//		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int matrix[][] = { { 6, 6, 2, 28, 2 }, { 12, 26, 3, 28, 7 }, { 22, 25, 3, 4, 23 } };
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

			// Print the first row from the remaining rows
			for (i = l; i < n; ++i) {
				System.out.print(matrix[k][i] + " ");
			}
			k++;

			// Print the last column from the remaining
			// columns
			for (i = k; i < m; ++i) {
				System.out.print(matrix[i][n - 1] + " ");
			}
			n--;

			// Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					System.out.print(matrix[m - 1][i] + " ");
				}
				m--;
			}

			// Print the first column from the remaining
			// columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					System.out.print(matrix[i][l] + " ");
				}
				l++;

			}

		}
	}

}
